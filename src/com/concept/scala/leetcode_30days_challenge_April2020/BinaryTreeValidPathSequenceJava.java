package com.concept.scala.leetcode_30days_challenge_April2020;

/***
 *
 * Day 30 Java version
 * @see "https://leetcode.com/submissions/detail/332257634/?from=/explore/featured/card/30-day-leetcoding-challenge/532/week-5/3315/"
 * 63 / 63 test cases passed.
 * Status: Accepted
 * Runtime: 0 ms
 * Memory Usage: 40.2 MB
 *
 */
public class BinaryTreeValidPathSequenceJava {

    public boolean isValidSequence(TreeNodeForJava root, int[] arr) {


        return checkifValidPath(root, arr, arr.length, 0);
    }

    /*
        if (root == null || index >= len) return false
        if (root.left == null && root.right == null) return index == len - 1 && root.value == arr(index)
        if (root.value == arr(index)) return checkifValidPath(root.left, arr, len, index + 1) || checkifValidPath(root.right, arr, len, index + 1)


     */
    public boolean checkifValidPath(TreeNodeForJava root, int arr[], int len, int index) {

        if (root == null || index >= len) return false;
        if (root.left == null && root.right == null) return index == len - 1 && root.val == arr[index];
        if (root.val == arr[index])
            return checkifValidPath(root.left, arr, len, index + 1) || checkifValidPath(root.right, arr, len, index + 1);
        return false;

    }

    public static void main(String args[]) {

        BinaryTreeValidPathSequenceJava obj = new BinaryTreeValidPathSequenceJava();
        // arr[] is sequence of root to leaf path 
        int arr[] = {5, 8, 6, 7};
        TreeNodeForJava root = new TreeNodeForJava(5);
        root.left = new TreeNodeForJava(3);
        root.right = new TreeNodeForJava(8);
        root.left.left = new TreeNodeForJava(2);
        root.left.right = new TreeNodeForJava(4);
        root.left.left.left = new TreeNodeForJava(1);
        root.right.left = new TreeNodeForJava(6);
        root.right.left.right = new TreeNodeForJava(7);

        if (obj.isValidSequence(root, arr)) {
            System.out.print("Path Exists");
        } else {
            System.out.print("Path does not Exist");
        }
    }
}
