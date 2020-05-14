package com.concept.scala.leetcode_30days_challenge_May2020

import com.concept.scala.RunTimeCalculation

/** *
  * Day 14
  *
  * @see  https://leetcode.com/problems/implement-trie-prefix-tree/
  *       OR
  *       https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/
  *
  *
  *       Implement a trie with insert, search, and startsWith methods.
  *
  *       Example:
  *
  *       Trie trie = new Trie();
  *
  *       trie.insert("apple");
  *       trie.search("apple");   // returns true
  *       trie.search("app");     // returns false
  *       trie.startsWith("app"); // returns true
  *       trie.insert("app");
  *       trie.search("app");     // returns true
  *
  *       Note:
  *
  *       You may assume that all inputs are consist of lowercase letters a-z.
  *       All inputs are guaranteed to be non-empty strings
  *
  *
  *
  *       15 / 15 test cases passed.
  *       Status: Accepted
  *       Runtime: 820 ms
  *       Memory Usage: 67.1 MB
  *
  *       Runtime: 820 ms, faster than 100.00% of Scala online submissions for Implement Trie (Prefix Tree).
  *       Memory Usage: 67.1 MB, less than 100.00% of Scala online submissions for Implement Trie (Prefix Tree).
  *
  *
  */
class Trie () {

  /** Initialize your data structure here. */
  val root = new Node(new Array[Node](26), false)


  /** Inserts a word into the trie. */
  def insert (word: String) {
    var pointer = root
    for (ch <- word) {
      if (pointer.children(ch - 'a') == null)
        pointer.children(ch - 'a') = new Node(new Array[Node](26), false)

      pointer = pointer.children(ch - 'a')
    }
    pointer.isEndOfWord = true

  }

  /** Returns if the word is in the trie. */
  def search (word: String): Boolean = {
    val new_pointer = searchReuse(word)
    new_pointer != null && new_pointer.isEndOfWord

  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  def startsWith (prefix: String): Boolean = {
    searchReuse(prefix) != null
  }

  def searchReuse (string: String): Node = {
    var pointer = root
    for (char <- string) {
      if (pointer.children(char - 'a') == null) return null
      pointer = pointer.children(char - 'a')
    }
    pointer
  }


}

/**
  * Your Trie object will be instantiated and called as such:
  * var obj = new Trie()
  * obj.insert(word)
  * var param_2 = obj.search(word)
  * var param_3 = obj.startsWith(prefix)
  */
class Node (val children: Array[Node], var isEndOfWord: Boolean)


object Trie {
  def main (args: Array[String]): Unit = {
    val trie = new Trie()

    val totalRuntime = RunTimeCalculation.calculateRunTime {
      trie.insert("apple")
      println(trie.search("apple")) // returns true
      println(trie.search("app")) // returns false
      println(trie.startsWith("app")) // returns true
      trie.insert("app")
      println(trie.search("app")) // returns true
    }
    println(s" total run time = seconds $totalRuntime seconds OR ${totalRuntime * 1000} milliseonds")
    /*
    true
    false
    true
    true
     total run time = seconds 0.688 seconds OR 688.0 milliseonds


     */
  }
}