package com.concept.scala.leetcode_30days_challenge_April2020

import scala.collection.mutable

/** *
  * Day 10
  *
  * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
  *
  * push(x) -- Push element x onto stack.
  * pop() -- Removes the element on top of the stack.
  * top() -- Get the top element.
  * getMin() -- Retrieve the minimum element in the stack.
  *
  *
  * Example:
  *
  * MinStack minStack = new MinStack();
  * minStack.push(-2);
  * minStack.push(0);
  * minStack.push(-3);
  * minStack.getMin();   --> Returns -3.
  * minStack.pop();
  * minStack.top();      --> Returns 0.
  * minStack.getMin();   --> Returns -2.
  *
  * 18 / 18 test cases passed.
  * Status: Accepted
  * Runtime: 752 ms
  * Memory Usage: 60.8 MB
  *
  *
  */

class MinStack {

  /** initialize your data structure here. */
  private val mins = mutable.Stack[Int]()
  private val stack = mutable.Stack[Int]()

  def top (): Int = {
    stack.top
  }

  def getMin (): Int = {
    mins.top
  }

  def push (x: Int) = {
    if (mins.isEmpty || mins.top >= x)
      mins.push(x)
    stack.push(x)
  }

  def pop () = {
    if (mins.top == top)
      mins.pop()
    stack.pop()
  }


}


object MinStack {
  def main (args: Array[String]): Unit = {


    val obj = new MinStack()


    obj.push(12)
    obj.push(23)
    obj.push(3)
    obj.push(13)
    obj.pop() // remove 13
    obj.push(14)
    println(obj.top()) // print top
    println(obj.getMin()) // print min
  }
}


/**
  * Your MinStack object will be instantiated and called as such:
  * var obj = new MinStack()
  * obj.push(x)
  * obj.pop()
  * var param_3 = obj.top()
  * var param_4 = obj.getMin()
  */