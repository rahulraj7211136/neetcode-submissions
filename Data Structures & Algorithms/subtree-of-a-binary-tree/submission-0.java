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
    private String serealize(TreeNode root) {
        if(root == null) return "N";
        return "(" + root.val + "," + serealize(root.left) + "," + serealize(root.right) + ")";
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String r = serealize(root);
        String s = serealize(subRoot);
        return r.contains(s);
    }
}
