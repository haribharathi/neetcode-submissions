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
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return output;
        }
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            int i = 0;
            List<Integer> each = new ArrayList<>();
            while (i < size) {
                TreeNode node = queue.remove();
                each.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                i++;
            }
            list.add(each);
        }
        for (List<Integer> each: list) {
            output.add(each.get(each.size() - 1));
        }
        return output;
    }
}
