package com.concept.scala.customFileSystem.commands

import com.concept.scala.customFileSystem.fileSystem.State

/**
  * Command is an entity which can transform one State to anorther
  */
trait Command {
  def apply(state: State): State
}

object Command {
  val MKDIR = "mkdir"

  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state
  }

  def inCompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State = state.setMessage(s"$name: incomplete command!")
  }

  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")
    if (input.isEmpty || tokens.isEmpty) emptyCommand else if (MKDIR.equals(tokens.head)) {
      if (tokens.length < 2) inCompleteCommand(MKDIR)
      else
        new MkDir(tokens.tail.head)
    } else new UknownCommand
  }
}