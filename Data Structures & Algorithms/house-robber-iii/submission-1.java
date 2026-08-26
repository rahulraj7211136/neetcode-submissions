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
    class Node {
        int val;
        int child;
        Node(int val, int child) {
            this.val = val;
            this.child = child;
        }
    }
    private Node solve(TreeNode root) {
        if(root == null)return new Node(0,0);
        Node l = solve(root.left);
        Node r = solve(root.right);
        return new Node(root.val + l.child + r.child, Math.max(l.val, l.child) + Math.max(r.val, r.child));
    }
    public int rob(TreeNode root) {
        if(root == null) return 0;
        Node ans = solve(root);
        return Math.max(ans.val, ans.child);
    }
}