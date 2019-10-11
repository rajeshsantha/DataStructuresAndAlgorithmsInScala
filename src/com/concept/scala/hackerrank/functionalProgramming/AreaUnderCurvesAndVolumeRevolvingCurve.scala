package com.concept.scala.hackerrank.functionalProgramming

/**
  * @author Rajesh Santha
  * @version 1.3
  * @todo refer the below link
  * @note Use functional programming, avoid imperative programming (no Vars, no loops, no side effects)
  *       P.S  : Its more of a calculus problem than a functional programming.
  *       In case if you want to get understanding of the problem, refer
  *       https://www.intmath.com/applications-integration/4-volume-solid-revolution.php
  *
  * @see https://www.hackerrank.com/challenges/area-under-curves-and-volume-of-revolving-a-curv/problem
  *
  *
  */
object AreaUnderCurvesAndVolumeRevolvingCurve extends App{

  def f (coefficients: List[Int], powers: List[Int], x: Double): Double = coefficients.zip(powers).map(a => a._1 * Math.pow(x, a._2)).sum

  def area (coefficients: List[Int], powers: List[Int], x: Double): Double = math.Pi * Math.pow(f(coefficients, powers, x), 2)

  def summation (func: (List[Int], List[Int], Double) => Double, upperLimit: Int, lowerLimit: Int, coefficients: List[Int], powers: List[Int]): Double = {
    val step = 0.001
    (lowerLimit.toDouble to upperLimit.toDouble by step).map(x => func(coefficients, powers, x) * step).sum
  }

}

