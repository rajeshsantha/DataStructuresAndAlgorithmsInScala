package com.concept.scala.customFileSystem.commands

import com.concept.scala.customFileSystem.fileSystem.State
import com.concept.scala.customFileSystem.files.{DirEntry, Directory}

case class MkDir(name: String) extends Command {

  def checkIllegal(name: String): Boolean = name contains "."


  def doMkdir(state: State, name: String): State = {
    def updateStructure(currentDirectory: Directory, paths: List[String], newEntry: DirEntry): Directory = {
      if (paths.isEmpty) currentDirectory.addEntry(newEntry)
      else {
        /*
         if currentDirectory is /a
         and path is  List("b")
         */
        println(paths)
        println(currentDirectory.findEntry(paths.head))
        println(paths.head.isEmpty)
        val oldEntry = currentDirectory.findEntry(paths.head).asDirectory
        currentDirectory.replaceEntry(oldEntry.name, updateStructure(oldEntry, paths.tail, newEntry))

      }
    }

    //get current working directory
    val wd = state.wd

    //1 Get all the dirs with full path
    val allDirsInPath = wd.getAllFoldersInPath

    //2 create new dir entry in the wd
    val newDir = Directory.empty(wd.path, name)

    //3 update the entire directory structure starting from the root
    val newRoot = updateStructure(state.root, allDirsInPath, newDir)

    // 4 find new working dir instance given wd's full path, in the new directory structure.
    val newWd = newRoot.findDescendant(allDirsInPath)

    //return the new state with updated directory
    State(newRoot, newWd)
  }

  override def apply(state: State): State = {

    val workdingDirectory = state.wd
    if (workdingDirectory hasEntry name) {
      state.setMessage(s"$name already exists!")
    } else if (name contains Directory.SEPERATOR) {
      state.setMessage(s"$name must not contains SEPERATORs")
    } else if (checkIllegal(name)) {
      state.setMessage(s"$name: illegal entry name!")
    }
    else {
      doMkdir(state, name)
    }
  }
}
