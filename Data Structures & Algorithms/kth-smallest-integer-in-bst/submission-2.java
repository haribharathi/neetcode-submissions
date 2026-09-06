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
    public int n = 0;
    public int output = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return output;
    }

    public void traverse(TreeNode node, int k){
        if (node == null) {
            return;
        }
        //System.out.println("n " + n + "node " +node.val);
        traverse(node.left, k);
        n++;
        if (k == n) {
            output = node.val;
            return;
        }
        traverse(node.right, k);
    }

    // public void traverse(TreeNode node, int k, int n) {
    //     if (node == null) {
    //         return;
    //     }
    //     n++;
    //     System.out.println("n " + n + "node " +node.val);
    //     if (k == n) {
    //         output = node.val;
    //         return;
    //     }
    //     traverse(node.left, k);
    //     if (k ==n) {
    //         System.out.println("again n " + n + "node " +node.val);
    //         output = node.val;
    //     }
    //     traverse(node.right, k);
    //     //System.out.println("n " + n + " node" + node.val);
    //     // if (k == n) {
    //     //     output = node.val;
    //     //     n++;
    //     // } else {
    //     //     n++;
    //     //     traverse(node.left, k);
    //     //     if (k ==n) {
    //     //         output = node.val;
    //     //         n++;
    //     //     }
    //     //     traverse(node.right, k);
    //     // }
    // }
}
