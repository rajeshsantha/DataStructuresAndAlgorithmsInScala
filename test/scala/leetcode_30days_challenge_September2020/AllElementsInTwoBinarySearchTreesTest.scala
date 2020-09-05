package scala.leetcode_30days_challenge_September2020

import com.concept.scala.leetcode_30days_challenge_April2020.TreeNode
import com.concept.scala.leetcode_30days_challenge_September2020.AllElementsInTwoBinarySearchTrees.getAllElements
import scala.Util.MyScalaTestUtil

class AllElementsInTwoBinarySearchTreesTest extends MyScalaTestUtil {

  trait TestAllElementsInTwoBinarySearchTrees {
    //root1 = [2,1,4], root2 = [1,0,3] ==> Output: List(0, 1, 1, 2, 3, 4)

    val root1 = new TreeNode(2)
    root1.left = new TreeNode(1)
    root1.right = new TreeNode(4)
    val root2 = new TreeNode(1)
    root2.left = new TreeNode(0)
    root2.right = new TreeNode(3)

    val testcase1_result: List[Int] = getAllElements(root1, root2)
  }

  "Result" should "containing all the integers from both trees sorted in ascending order" in new TestAllElementsInTwoBinarySearchTrees {
    testcase1_result should be(List(0, 1, 1, 2, 3, 4))
  }
}
