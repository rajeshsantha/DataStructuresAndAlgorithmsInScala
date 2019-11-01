package com.concept.scala.hackerrank.warmups

/**
  * @see https://www.hackerrank.com/challenges/time-conversion/problem
  */
object TimeConversion {
  def main (args: Array[String]): Unit = {
    val inputTime1 = "11:00:54AM"
    val inputTime2 = "9:45:54PM"
    val inputTime3 = "12:45:54PM"
    println(convertTo24HFormat(inputTime1)) //11:00:54
    println(convertTo24HFormat(inputTime2)) // 21:45:54
    println(convertTo24HFormat(inputTime3)) // 12:45:54
    /*
        val len = inputTime length
        val meridiem = inputTime substring (len - 2)
        val timeArray = inputTime slice(0, len - 2) split (":")

        if (meridiem == "PM") {
          val hour = if (timeArray(0) != "12") timeArray(0).toInt + 12 else timeArray(0).toInt

          println(hour + ":" + timeArray.drop(1).mkString(":"))
        }
        if (meridiem == "AM") {
          if (timeArray(0) == "12") timeArray(0) = "00"

          println(timeArray.mkString(":"))
        }
    */

  }

  def convertTo24HFormat (inputTime: String): String = {
    val len = inputTime length
    val meridiem = inputTime substring (len - 2)
    val timeArray = inputTime slice(0, len - 2) split (":")

    val finalTime = meridiem match {
      case "AM" => if (timeArray(0) == "12") timeArray(0) = "00"; timeArray.mkString(":")


      case "PM" => {
        val hour = if (timeArray(0) != "12") timeArray(0).toInt + 12 else timeArray(0).toInt
        hour + ":" + timeArray.drop(1).mkString(":")
      }
    }
    finalTime
  }
}
