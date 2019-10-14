package com.concept.scala

import scala.collection.mutable

/**
  * WordCount code To test the scala setup.
  */
object WordCount extends App {

  val wordcountMap = countWords("THIS COMMENT COPIED FROM REDDIT" +
    "Last I looked, scala jobs pay higher. " +
    "Yes, it is used for data processing and distributed programming a lot, but it also has an excellent web server (play) and supports a very sleek reactive framework (akka)" +
    "It's lambda implementation is also way more intuitive than Java's. " +
    "In other words, it is becoming a very versatile toolset." +
    "Also, ask any former java programmer with 6 months scala experience if they would like to go back to java. " +
    "I haven't yet met one.")

  wordcountMap.toList.sortBy(-_._2).foreach(println) // Sort by order of count of wordsḌ



  def countWords (text: String) = {
    val counts = mutable.Map.empty[String, Int]
    for (rawWord <- text.split("[ ,!.]()+")) {
      val word = rawWord.toLowerCase
      val oldCount =
        if (counts.contains(word) && word !="") counts(word)
        else 0
      counts += (word -> (oldCount + 1))
    }
    counts
  }
}
