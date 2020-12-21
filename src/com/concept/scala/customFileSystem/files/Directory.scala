package com.concept.scala.customFileSystem.files

import scala.annotation.tailrec

class Directory(override val parentPath: String, override val name: String, val contents: List[DirEntry])
  extends DirEntry(parentPath, name) {
  def replaceEntry(entryName: String, newEntry: DirEntry): Directory =
    new Directory(parentPath, name, contents.filter(!_.name.equals(entryName)) :+ newEntry)


  def findEntry(entryName: String): DirEntry = {
    @tailrec
    def findEntryHelper(name: String, contentList: List[DirEntry]): DirEntry = {
      if (contentList.isEmpty) null
      else if (contentList.head.name.equals(name)) contentList.head
      else findEntryHelper(name, contentList.tail)
    }

    findEntryHelper(entryName, contents)
  }

  def addEntry(newEntry: DirEntry): Directory = {
    new Directory(parentPath, name, contents :+ newEntry)

  }

  def findDescendant(allDirsInPath: List[String]): Directory = {
    if (allDirsInPath.isEmpty) this
    else findEntry(allDirsInPath.head).asDirectory.findDescendant(allDirsInPath.tail)
  }

  def hasEntry(name: String): Boolean = findEntry(name) != null

  def getAllFoldersInPath: List[String] = path.substring(1)
    .split(Directory.SEPERATOR)
    .toList
    .filter(!_.isEmpty)

  override def asDirectory: Directory = this

  override def getType: String = "Directory"
}

object Directory {
  val SEPERATOR = "/"
  val ROOT_PATH = "/"

  def empty(parentPath: String, name: String): Directory = new Directory(parentPath, name, List())

  def ROOT: Directory = Directory.empty("", "")
}