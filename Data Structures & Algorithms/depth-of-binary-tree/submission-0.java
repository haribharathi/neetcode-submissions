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
    public int maxDepth(TreeNode root) {
        return recursive(root, 0);
    }

    public int recursive(TreeNode root, Integer depth) {
        if (root == null) {
            return depth;
        }
         depth = depth + 1;
        int leftdepth = recursive(root.left, depth);
        int rightdepth = recursive(root.right, depth);
        return Math.max(leftdepth, rightdepth);
    }
}
