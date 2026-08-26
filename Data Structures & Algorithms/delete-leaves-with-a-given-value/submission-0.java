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
    private boolean isEdge(TreeNode node) {
        return node.left == null && node.right == null;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null)return null;
        TreeNode l = removeLeafNodes(root.left, target);
        TreeNode r = removeLeafNodes(root.right, target);
        root.left = l;
        root.right = r;
        if(root.val == target && isEdge(root)) {
            return null;
        }
        return root;
    }
}