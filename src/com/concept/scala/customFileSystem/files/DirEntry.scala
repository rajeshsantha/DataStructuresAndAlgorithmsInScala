package com.concept.scala.customFileSystem.files

/** *
  *
  * could be either Dir or File
  *
  * @param parentPath
  * @param name
  */
abstract class DirEntry(val parentPath: String, val name: String) {
  def path: String = parentPath + Directory.SEPERATOR + name

  def asDirectory: Directory

  def getType:String
}
