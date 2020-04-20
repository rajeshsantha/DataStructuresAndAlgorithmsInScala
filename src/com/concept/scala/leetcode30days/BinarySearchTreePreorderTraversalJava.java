package com.concept.scala.leetcode30days;


/****
 *
 *
 *   * Day 20
 *   *
 *   * @see https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3305/
 *   *
 *   *      OR
 *   *      https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal
 *   *
 *   *      Return the root node of a binary search tree that matches the given preorder traversal.
 *   *
 *   *      (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
 *   *
 *   *
 *   *
 *   *      Example 1:
 *   *
 *   *      Input: [8,5,1,7,10,12]
 *   *      Output: [8,5,10,1,7,null,12]
 *   *
 *
 *
 *          Set root = preorder[0]
 *          Starting from index 1, For each element in preorder,
 *
 *          Check if the target is greater than or smaller than root.
 *   	     a) -> If smaller than root, then
 *   				  if left is null, then assign the target value to left
 *   				  else go further left.
 *   	     b) -> If greater than root, then
 *   				  if right is null, then assign the target value to right
 *   				  else go further right.
 *
 *
 *
 */


class BinarySearchTreePreorderTraversalJava {

    public TreeNode2 bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode2 helper(int[] preorder, int start, int end) {
        if (start > end) return null;

        TreeNode2 node = new TreeNode2(preorder[start]);
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.val)
                break;
        }

        node.left = helper(preorder, start + 1, i - 1);
        node.right = helper(preorder, i, end);
        return node;


    }


}

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int x) {
        val = x;
    }
}
