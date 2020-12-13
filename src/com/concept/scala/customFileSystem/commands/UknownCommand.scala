package com.concept.scala.customFileSystem.commands

import com.concept.scala.customFileSystem.fileSystem.State

class UknownCommand extends Command {
  override def apply(state: State): State = state.setMessage("Command not found!")
}
