package com.dsa.scala.functionalDataStructuresAndAlgorithms

import com.concept.scala.RunTimeCalculation

/** *
  *
  * @todo find the index of the pattern(if exists) in input string by using naive backtracking method
  * @example if input string is "when a job is scheduled to execute every minute by using cron.d in Linux and that job fetches and updates items from a queue persisted in MySQL, that job can take longer than 1 minute to execute and thus you can end up with 2 or 3 processes executing at the same time and contending on the same MySQL table."
  *          and target patter is "MySQL"
  *          return 138 (MySQL first ocuurance is at 138th index of input string)
  *
  */
object NaiveSubStringPatternSearch {
  val inputString = "when a job is scheduled to execute every minute by using cron.d in Linux and that job fetches and updates items from a queue persisted in MySQL, that job can take longer than 1 minute to execute and thus you can end up with 2 or 3 processes executing at the same time and contending on the same MySQL table."
  val patterToSearch = "MySQL"

  def main(args: Array[String]): Unit = {

    println("******** naiveSubStringSearch_iterative **********")
    val iterativeRuntime = RunTimeCalculation.calculateRunTime(printResult(naiveSubStringSearch_iterative(inputString, patterToSearch)))
    print(s"         =>  took ${iterativeRuntime * 1000} milliseconds")

    println("\n******** naiveSubStringSearch_functional **********")
    val functionalRuntime = RunTimeCalculation.calculateRunTime(printResult(naiveSubStringSearch_functional(inputString, patterToSearch)))
    print(s"         =>  took ${functionalRuntime * 1000} milliseconds")

    println("\n******** naiveSubStringSearch_builtin **********")
    val builtinRuntime = RunTimeCalculation.calculateRunTime(printResult(naiveSubStringSearch_builtin(inputString, patterToSearch)))
    print(s"         =>  took ${builtinRuntime * 1000} milliseconds")
    /*
    output:
      ******** naiveSubStringSearch_iterative **********
     MySQL found at index 138         =>  took 28.0 milliseconds
    ******** naiveSubStringSearch_functional **********
     MySQL found at index 138         =>  took 14.0 milliseconds
    ******** naiveSubStringSearch_builtin **********
     MySQL found at index 138         =>  took 0.0 milliseconds

     */
  }

  def naiveSubStringSearch_iterative(input: String, target: String): Int = {
    var indexFound = -1
    val inputLength = input.length
    val targetLength = target.length
    for (i <- 0 to inputLength - targetLength if indexFound == -1) {
      var tempIndex = 0
      while (tempIndex < targetLength && input(i + tempIndex) == target(tempIndex)) tempIndex += 1
      if (tempIndex == targetLength) indexFound = i
    }
    indexFound
  }

  def printResult(result: Int): Unit = result match {
    case -1 => print(s" $patterToSearch not found")
    case _ => print(s" $patterToSearch found at index $result")
  }

  def naiveSubStringSearch_functional(input: String, target: String): Int =
    input.indices.find(index => input.length >= index + target.length && target.indices.forall(tIndex => inputString(index + tIndex) == target(tIndex))) getOrElse -1


  def naiveSubStringSearch_builtin(input: String, target: String): Int = input indexOf target

}
