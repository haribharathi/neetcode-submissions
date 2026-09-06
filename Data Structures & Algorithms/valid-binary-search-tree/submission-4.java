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
    public boolean isValidBST(TreeNode root) {
        return traverse2(root, -1000000000, 1000000000, "left") && traverse2(root, -1000000000, 1000000000, "right");
    }

    public boolean traverse2(TreeNode node, Integer min, Integer max, String comp) {
        if (node == null) {
            return true;
        }
        // // if (comp.equals("left")) {
        //     if (node.val > min && node.val < max) {
        //         return traverse2(node.left, min, node.val);
        //     } else {
        //         return false;
        //     } 
        // // }
        // // if (comp.equals("right")) {
        //     if (node.val > min && node.val < max) {
        //         return traverse2(node.right, node.val, max);
        //     } else {
        //         return false;
        //     } 
        // }
            if (node.val > min && node.val < max) {
                return traverse2(node.right, node.val, max, "left") && traverse2(node.left, min, node.val, "right");
            } else {
                return false;
            }
    }   

    // public boolean traverse(TreeNode node, Integer val, String comp) {
    //     if (node == null) {
    //         return true;
    //     }
    //     if (comp.equals("left")) {
    //         if (node.val > val || node.val > list[0]) {
    //             System.out.println("left is false" + node.val + " " + list[0]);
    //             return false;
    //         } else {
    //             list[0] = node.val;
    //         }
    //     }
    //     if (comp.equals("right")) {
    //         if (node.val < val || node.val < list[1]) {
    //             System.out.println("right is false" + node.val + " " + list[1]);
    //             return false;
    //         } else {
    //             list[1] = node.val;
    //         }
    //     }
    //     return traverse(node.left, node.val, "left") && traverse(node.right, node.val, "right");
    // }
}
