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

class Node {
    int height;
    boolean isBalanced;
    Node(int h, boolean b) {
        this.height = h;
        this.isBalanced = b;
    }
}

class Solution {
    private Node helper(TreeNode root) {
        if(root == null) {
            return new Node(0, true);
        }
        Node l = helper(root.left);
        Node r = helper(root.right);
        int height = Math.max(l.height, r.height) + 1;
        if(Math.abs(l.height-r.height) <= 1 && l.isBalanced && r.isBalanced) {
            return new Node(height, true);
        }
        return new Node(height, false);
    }
    public boolean isBalanced(TreeNode root) {
        Node ans = helper(root);
        return ans.isBalanced;
    }
}
