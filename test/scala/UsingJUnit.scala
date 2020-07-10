package scala


import org.junit.Test
import org.junit.Assert._
import com.concept.scala.DecimalToBinary.convertDecimalToBinaryFunctional
import scala.collection.mutable.ListBuffer

/** *
  * sample junit test case for scala
  */
class UsingJUnit {
  @Test
  def addList(): Unit = {
    val list = ListBuffer[String]()
    list append "someItem"
    list append "someItem0"
    list.append("SomeItem1")
    assertEquals(3, list.size)
  }

  @Test
  def doubleElements(): Unit = {
    val input = Array(1, 2, 3, 4, 5)
    val output = Array(2, 4, 6, 8, 10)
    assert(output.map(_ / 2) sameElements input, "same")
  }

  @Test
  def testConvertDecimalToBinaryFunctional: Unit = {
    assertEquals(convertDecimalToBinaryFunctional(45), 45.toBinaryString)
  }


}
