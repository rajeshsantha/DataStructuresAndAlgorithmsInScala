package com.concept.scala.leetcode_30days_challenge_July2020

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/** *
  * Day 8
  *
  * @todo Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
  * @note The solution set must not contain duplicate triplets.
  * @example Given array nums = [-1, 0, 1, 2, -1, -4],
  *
  *          A solution set is:
  *          [
  *          [-1, 0, 1],
  *          [-1, -1, 2]
  *          ]
  *
  *
  *
  */
object _3Sum {
  def main(args: Array[String]): Unit = {
    val nums = Array(-1, 0, 1, 2, -1, -4)
    println(threeSumByHashMap(nums))
  }

  //MemoryLimitException
  def threeSum(nums: Array[Int]): List[List[Int]] =
    nums.sorted.combinations(3).map(x => if (x.sum == 0) x else 0).filter(x => x != 0).map(x => x.asInstanceOf[Array[Int]]).toArray.map(_.toList).toList

  //RuntimeLimitException
  def threeSumByHashMap(nums: Array[Int]): List[List[Int]] = {
    import scala.collection.mutable
    val pairs = mutable.HashMap[Int, List[Int]]()
    nums.zipWithIndex.foreach({ case (x, idx) => pairs(x) = idx :: pairs.getOrElse(x, Nil) })

    def twoSum(num1: Int, idx1: Int): List[List[Int]] = {
      val res = for {
        (num2, idx2) <- nums.iterator.zipWithIndex.collect({ case (x, idx) if idx != idx1 => x -> idx })
        num3 <- pairs.getOrElse(-num1 - num2, Nil).filterNot(List(idx1, idx2).contains(_)).map(nums).take(1)
      } yield {
        (num1 :: num2 :: num3 :: Nil).sorted
      }
      res.toList
    }

    pairs.flatMap({ case (key, value :: tail) => twoSum(key, value) case _ => Nil })
      .foldLeft(List[List[Int]]())({ case (acc, x) if !acc.contains(x) => x :: acc case (acc, _) => acc })


  }


}

/*

Java alternative
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i + 2 < nums.length; i++) {
        if (nums[i] > 0) break;
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        int j = i + 1, k = nums.length - 1;
        int target = -nums[i];
        while (j < k) {
            if (nums[j] + nums[k] == target) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
                while (j < k && nums[j] == nums[j - 1]) j++;
                while (j < k && nums[k] == nums[k + 1]) k--;
            } else if (nums[j] + nums[k] > target) {
                k--;
            } else {
                j++;
            }
        }
    }
    return result;

    }
}
 */