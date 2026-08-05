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
        TreeNode node;
        int level;
        Node(TreeNode n, int l) {
            this.node = n;
            this.level = l;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        TreeMap<Integer, TreeNode> mp = new TreeMap<>();
        q.add(new Node(root, 0));
        while(!q.isEmpty()) {
            Node front = q.poll();
            int level = front.level;
            TreeNode node = front.node;
            if(!mp.containsKey(level)) {
                mp.put(level, node);
            }
            if(node.right != null) {
                q.add(new Node(node.right, level + 1));
            }
            if(node.left != null) {
                q.add(new Node(node.left, level + 1));
            }
        }
        for(Map.Entry<Integer, TreeNode> entry : mp.entrySet()) {
            ans.add(entry.getValue().val);
        }
        return ans;
    }
}
