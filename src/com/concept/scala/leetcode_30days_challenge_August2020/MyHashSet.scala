package com.concept.scala.leetcode_30days_challenge_August2020

/** **
  *
  * Day 2
  *
  * @todo Design a HashSet without using any built-in hash table libraries.
  *       To be specific, your design should include these functions:
  *       add(value): Insert a value into the HashSet.
  *       contains(value) : Return whether the value exists in the HashSet or not.
  *       remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
  * @example self explnatory (look at main method)
  * @note All values will be in the range of [0, 1000000].
  *       The number of operations will be in the range of [1, 10000].
  *       Please do not use the built-in HashSet library.
  * @see https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3410/
  *      OR
  *      https://leetcode.com/problems/design-hashset/
  *
  *
  *
  */
object MyHashSet {

  def main(args: Array[String]): Unit = {
    // Your MyHashSet object will be instantiated and called as such:
    var obj = new MyHashSet()
    obj.add(3)
    obj.add(4)
    obj.add(3)
    obj.remove(4)
    obj.remove(9)
    obj.contains(3)

  }

}

/** *
  *
  * 28 / 28 test cases passed.
  * Status: Accepted
  * Runtime: 1648 ms
  * Memory Usage: 64.5 MB
  */
class MyHashSet() {

  /** Initialize your data structure here. */
  val lb = new scala.collection.mutable.ListBuffer[Int]()

  def add(key: Int) {
    if (!lb.contains(key)) lb.append(key)
  }

  def remove(key: Int) {
    if (lb.contains(key)) lb.remove(lb.indexOf(key))
  }

  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = {
    lb contains key
  }

}

/*
class MyHashSetMutable() {

  /** Initialize your data structure here. */
  var lb: List[Int] = List[Int]()

  def add(key: Int) {
    if (!lb.contains(key)) lb :+= key
  }

  def remove(key: Int) {
    if (lb contains key) lb = lb.filter(_ != key)
  }

  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = {
    lb contains key
  }

}

*/
