package com.concept.scala.customFileSystem.commands

import com.concept.scala.customFileSystem.fileSystem.State
import com.concept.scala.customFileSystem.files.DirEntry

class Ls extends Command {

  def createNiceOutput(contents: List[DirEntry]): String = {
    if (contents.isEmpty) ""
    else {
      val entry = contents.head
      entry.name + "[" + entry.getType + "] \n" + createNiceOutput(contents.tail)
    }
  }

  override def apply(state: State): State = {
    val contents = state.wd.contents
    val niceOuput = createNiceOutput(contents)
    state.setMessage(niceOuput)
  }
}
