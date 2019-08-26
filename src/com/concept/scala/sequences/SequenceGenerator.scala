package com.concept.scala.sequences

trait SequenceGenerator {
  //unimplmented method
  def generate (total: Int): List[Int]

  //implmented method
  def generateStr (total: Int): String = generate(total).mkString(",")

}
