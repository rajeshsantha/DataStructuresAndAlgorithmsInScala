package com.concept.scala

import scala.collection.mutable.ListBuffer

object IntersectScala {

  def main(args: Array[String]): Unit = {
    val x = List(5,7,2,6,4)
    val y = List(4,5,1,3,9)

    //println(intersection_imperativeStyle(x,y))
    //println(intersection_functionalStyle(x,y))
    println(intersection_inbuiltStyle(x,y))
  }

  def intersection_imperativeStyle(x:List[Int],y:List[Int]):List[Int]={
    val inter =ListBuffer[Int]()

    x.foreach { i =>
      y.foreach{j =>
        if (i == j) {
          inter += i
        }
      }
    }
    inter.toList
  }
  def intersection_functionalStyle(x:List[Int],y:List[Int]):List[Int]= x.filter(i=>y.contains(i))
  def intersection_inbuiltStyle(x:List[Int],y:List[Int]):List[Int]= x.intersect(y)

}
