/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    Integer count = 0;
    public int goodNodes(TreeNode root) {
        if ( root == null) {
            return 0;
        }
        traverse(root, -101);
        return count;
    }
    public void traverse(TreeNode node, Integer val) {
        if (node == null) {
            return;
        }
        if (node.val >= val) {
            val = node.val;
            count++;
        }
        traverse(node.left, val);
        traverse(node.right, val);
    }
}
