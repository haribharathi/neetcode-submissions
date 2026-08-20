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
    public TreeNode invertTree(TreeNode root) {
        TreeNode newNode = new TreeNode();
        return recursiveTree(root,newNode);
    }

    public TreeNode recursiveTree(TreeNode node, TreeNode newNode) {
        if (node == null) {
            return null;
        }
        TreeNode leftNode = recursiveTree(node.left,newNode);
        TreeNode rightNode = recursiveTree(node.right,newNode);
        //newNode.val = node.val;
        node.right = leftNode;
        node.left = rightNode;
        return node;
    }
}
