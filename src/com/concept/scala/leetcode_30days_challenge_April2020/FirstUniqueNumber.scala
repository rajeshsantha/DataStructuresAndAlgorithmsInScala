package com.concept.scala.leetcode_30days_challenge_April2020


/** *
  * Day 28
  *
  * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3313/
  *
  *      You have a queue of integers, you need to retrieve the first unique integer in the queue.
  *
  *      Implement the FirstUnique_Java class:
  *
  *      FirstUnique_Java(int[] nums) Initializes the object with the numbers in the queue.
  *      int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
  *      void add(int value) insert value to the queue.
  *
  *
  *      Example 1:
  *
  *      Input:
  *      ["FirstUnique_Java","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
  *      [[[2,3,5]],[],[5],[],[2],[],[3],[]]
  *      Output:
  *      [null,2,null,2,null,3,null,-1]
  *
  *      Explanation:
  *      FirstUnique_Java firstUnique = new FirstUnique_Java([2,3,5])
  * firstUnique.showFirstUnique() // return 2
  * firstUnique.add(5)            // the queue is now [2,3,5,5]
  * firstUnique.showFirstUnique() // return 2
  * firstUnique.add(2)            // the queue is now [2,3,5,5,2]
  * firstUnique.showFirstUnique() // return 3
  * firstUnique.add(3)            // the queue is now [2,3,5,5,2,3]
  * firstUnique.showFirstUnique() // return -1
  *
  *      Example 2:
  *
  *      Input:
  *      ["FirstUnique_Java","showFirstUnique","add","add","add","add","add","showFirstUnique"]
  *      [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
  *      Output:
  *      [null,-1,null,null,null,null,null,17]
  *
  *      Explanation:
  *      FirstUnique_Java firstUnique = new FirstUnique_Java([7,7,7,7,7,7])
  * firstUnique.showFirstUnique() // return -1
  * firstUnique.add(7)            // the queue is now [7,7,7,7,7,7,7]
  * firstUnique.add(3)            // the queue is now [7,7,7,7,7,7,7,3]
  * firstUnique.add(3)            // the queue is now [7,7,7,7,7,7,7,3,3]
  * firstUnique.add(7)            // the queue is now [7,7,7,7,7,7,7,3,3,7]
  * firstUnique.add(17)           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
  * firstUnique.showFirstUnique() // return 17
  *
  *      Example 3:
  *
  *      Input:
  *      ["FirstUnique_Java","showFirstUnique","add","showFirstUnique"]
  *      [[[809]],[],[809],[]]
  *      Output:
  *      [null,809,null,-1]
  *
  *      Explanation:
  *      FirstUnique_Java firstUnique = new FirstUnique_Java([809])
  * firstUnique.showFirstUnique() // return 809
  * firstUnique.add(809)          // the queue is now [809,809]
  * firstUnique.showFirstUnique() // return -1
  *
  *
  *
  *      Constraints:
  *
  *      1 <= nums.length <= 10^5
  *      1 <= nums[i] <= 10^8
  *      1 <= value <= 10^8
  *      At most 50000 calls will be made to showFirstUnique and add.
  *
  *
  *
  *      17 / 17 test cases passed.
  *      Status: Accepted
  *      Runtime: 2552 ms
  *      Memory Usage: 131.1 MB
  *
  */
class FirstUniqueNumber (_nums: Array[Int]) {

  import scala.collection.mutable

  var set_Of_UniqueValues: mutable.LinkedHashSet[Int] = new mutable.LinkedHashSet().empty
  var set_Of_DuplicateValues: mutable.HashSet[Int] = new mutable.HashSet().empty

  _nums foreach add // execute add() foreach element in nums array

  def showFirstUnique (): Int = {
    if (set_Of_UniqueValues isEmpty) -1
    else set_Of_UniqueValues.iterator.next
  }

  def add (value: Int) {
    if (set_Of_DuplicateValues contains value) return

    if (set_Of_UniqueValues contains value) {
      set_Of_UniqueValues remove value
      set_Of_DuplicateValues add value
    }
    else set_Of_UniqueValues add value
  }

 // addByCaseMatch is just an optional implementation for above "add()" by using case match statements. Not part of an execution though
 
  def addByCaseMatch (value: Int) {

    if (set_Of_DuplicateValues contains value) return

    set_Of_UniqueValues contains value match {
      case true =>
        set_Of_UniqueValues remove value
        set_Of_DuplicateValues add value

      case false => set_Of_UniqueValues add value
    }

  }

}


object FirstUniqueNumber {

  def main (args: Array[String]): Unit = {

    val firstUnique = new FirstUniqueNumber(Array(2, 3, 5))
    contentOfSets_At_the_moment(firstUnique)
    firstUnique.showFirstUnique() // return 2
    contentOfSets_At_the_moment(firstUnique)
    firstUnique.add(5) // the queue is now [2,3,5,5]
    contentOfSets_At_the_moment(firstUnique)
    firstUnique.showFirstUnique() // return 2
    contentOfSets_At_the_moment(firstUnique)
    firstUnique.add(2) // the queue is now [2,3,5,5,2]
    contentOfSets_At_the_moment(firstUnique)
    firstUnique.showFirstUnique() // return 3
    contentOfSets_At_the_moment(firstUnique)
    firstUnique.add(3) // the queue is now [2,3,5,5,2,3]
    contentOfSets_At_the_moment(firstUnique)
    firstUnique.showFirstUnique() // return -1
    contentOfSets_At_the_moment(firstUnique)
  }

  def contentOfSets_At_the_moment (obj: FirstUniqueNumber) = println(s"\t\t\t\t unique set: ${obj.set_Of_UniqueValues} \t\tduplicate set : ${obj.set_Of_DuplicateValues}")

  /*

 First instatiate with array===>  unique set: Set(2, 3, 5) 		duplicate set : Set()
 firstUnique.showFirstUnique()=>  unique set: Set(2, 3, 5) 		duplicate set : Set()
 firstUnique.add(5)         ===>  unique set: Set(2, 3) 		  duplicate set : Set(5)
 firstUnique.showFirstUnique()=>  unique set: Set(2, 3) 		  duplicate set : Set(5)
 firstUnique.add(2)         ===>  unique set: Set(3) 		      duplicate set : Set(5, 2)
 firstUnique.showFirstUnique()=>  unique set: Set() 		      duplicate set : Set(5, 2, 3)
 firstUnique.add(3)         ===>  unique set: Set() 		      duplicate set : Set(5, 2, 3)
 firstUnique.showFirstUnique()=>  unique set: Set(3) 		      duplicate set : Set(5, 2)

   */
}
