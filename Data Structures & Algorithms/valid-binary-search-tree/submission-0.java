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
    private boolean solve(TreeNode root, int left, int right) {
        if(root == null) return true;
        if(left < root.val && right > root.val && solve(root.left, left, root.val) &&
        solve(root.right, root.val, right)) {
            return true;
        }
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return solve(root.left, Integer.MIN_VALUE, root.val) && 
                solve(root.right, root.val, Integer.MAX_VALUE);
    }
}
