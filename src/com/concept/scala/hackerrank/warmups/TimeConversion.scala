package com.concept.scala.hackerrank.warmups

/**
  * @see https://www.hackerrank.com/challenges/time-conversion/problem
  */
object TimeConversion {
  def main (args: Array[String]): Unit = {
    val inputTime = "12:45:54PM"
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

  }

}
