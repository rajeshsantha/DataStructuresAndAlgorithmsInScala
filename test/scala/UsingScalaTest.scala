package scala

import org.scalatest
import org.scalatest.{FlatSpec, Matchers}
import com.concept.scala.DecimalToBinary.convertDecimalToBinaryFunctional
import scala.collection.mutable.ListBuffer


class UsingScalaTest extends FlatSpec with Matchers {

  trait EmptyArrayList {
    val list = ListBuffer[String]()
  }

  trait NonEmptyArrayList {
    val list = ListBuffer[String]()
    list append "someItem"
    list append "someItem0"
    list.append("SomeItem1")

  }

  trait TestBinaryConversion {
    val result: String = convertDecimalToBinaryFunctional(45)
  }

  "a list" should "be empty on create" in new EmptyArrayList {
    Thread.sleep(2000)
    list.size should be(0)
    Thread.sleep(2000)
  }
  "a list" should "increase it's size after adding elements" in new NonEmptyArrayList {
    Thread.sleep(2000)
    list.size should be(3)
    Thread.sleep(2000)
  }
  "binary number" should "matching with builtin method result" in new TestBinaryConversion {
    result should be(45 toBinaryString)
    result should be(101101 toString)
  }
}
