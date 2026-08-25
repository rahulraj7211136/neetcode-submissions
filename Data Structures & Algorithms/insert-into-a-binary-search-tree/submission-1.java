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
    private void helper(TreeNode root, int val, int max, int min) {
        if(root == null)return;
        if(root.left == null && root.val > val) {
            root.left = new TreeNode(val);
        }
        if(root.right == null && root.val < val) {
            root.right = new TreeNode(val);
        }
        if(val > root.val) {
            helper(root.right, val, max, root.val);
        } else {
            helper(root.left, val, root.val, min);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        helper(root, val, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return root;
    }
}