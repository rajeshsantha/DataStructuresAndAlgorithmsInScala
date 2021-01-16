package com.concept.scala.customFileSystem.commands
import com.concept.scala.customFileSystem.fileSystem.State

class Pwd extends Command {
  override def apply(state: State): State = {
    state.setMessage(state.wd.path)
  }
}
