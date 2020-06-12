package com.concept.scala.leetcode_30days_challenge_June2020

import scala.collection.mutable


/** ***
  * Day 12
  *
  * @see  https://leetcode.com/problems/insert-delete-getrandom-o1/
  *       OR
  *       https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/
  *
  *
  *
  *
  *       Design a data structure that supports all following operations in average O(1) time.
  *
  *       insert(val): Inserts an item val to the set if not already present.
  *       remove(val): Removes an item val from the set if present.
  *       getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
  *       Example:
  *
  *       // Init an empty set.
  *       RandomizedSet randomSet = new RandomizedSet();
  *
  *       // Inserts 1 to the set. Returns true as 1 was inserted successfully.
  *       randomSet.insert(1);
  *
  *       // Returns false as 2 does not exist in the set.
  *       randomSet.remove(2);
  *
  *       // Inserts 2 to the set, returns true. Set now contains [1,2].
  *       randomSet.insert(2);
  *
  *       // getRandom should return either 1 or 2 randomly.
  *       randomSet.getRandom();
  *
  *       // Removes 1 from the set, returns true. Set now contains [2].
  *       randomSet.remove(1);
  *
  *       // 2 was already in the set, so return false.
  *       randomSet.insert(2);
  *
  *       // Since 2 is the only number in the set, getRandom always return 2.
  *       randomSet.getRandom();
  *
  *
  *
  */
class RandomizedSet {

  /** Initialize your data structure here. */
  private val buffer = mutable.ListBuffer[Int]()
  private val map = mutable.HashMap[Int, Int]()


  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  def insert (`val`: Int): Boolean = {
    val value = `val`
    if (map contains value) return false
    else {
      map.put(value, buffer.size)
      buffer.append(value)
    }
    true
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  def remove (`val`: Int): Boolean = {
    val value = `val`
    if (!map.contains(value)) return false
    else {
      val (lastElement, indexToRemove) = (buffer.length - 1, map(value))

      buffer.insert(indexToRemove, lastElement)
      buffer.remove(buffer.size - 1)

      map.put(lastElement, indexToRemove)
      map.remove(value)

    }
    true
  }

  /** Get a random element from the set. */
  // 15/18
  def getRandom (): Int = buffer(new scala.util.Random().nextInt(map.size))


}

object RandomizedSet {

  def main (args: Array[String]): Unit = {

    // ["RandomizedSet","remove","remove","insert","getRandom","remove","insert"]
    // [[],[0],[0],[0],[],[0],[0]]


    /*
        var obj = new RandomizedSet()
        var param_1 = obj.remove(0)
        var param_2 = obj.remove(0)
        var param_3 = obj.insert(0)
        var param_4 = obj.getRandom()
        var param_4_1 = obj.remove(0)

        var param_5 = obj.insert(0)
        //var param_6 = obj.getRandom()



        println(s" $param_1 \n $param_2 \n $param_3 \n $param_4 \n $param_4_1 \n $param_5 \n")
        obj.buffer.foreach(x => print(" " + x + " "))

    */

    //  ["RandomizedSet","insert","remove","insert","remove","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom"]
    //  [[],[0],[0],[-1],[0],[],[],[],[],[],[],[],[],[],[]]
    var obj2 = new RandomizedSet()
    println(obj2.insert(0))
    println(obj2.remove(0))
    println(obj2.insert(-1))
    println(obj2.remove(0))
    println(obj2.getRandom())
    println(obj2.getRandom())
    println(obj2.getRandom())
    println(obj2.getRandom())
    println(obj2.getRandom())
    println(obj2.getRandom())
    println(obj2.getRandom())
    println(obj2.getRandom())
    println(obj2.getRandom())
    println(obj2.getRandom())

    obj2.buffer.foreach(x => print(" " + x + " "))


  }

}