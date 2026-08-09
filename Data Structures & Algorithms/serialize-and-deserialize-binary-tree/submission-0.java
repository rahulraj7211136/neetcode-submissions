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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("N");
            } else {
                sb.append(Integer.toString(node.val));
                q.add(node.left);
                q.add(node.right);
            }
            sb.append(",");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] arr = data.split(",");
        int idx = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[idx]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty() && idx < arr.length) {
            TreeNode node = q.poll();
            idx++;
            if(idx < arr.length && !arr[idx].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(arr[idx]));
                q.add(node.left);
            }
            idx++;
            if(idx < arr.length && !arr[idx].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(arr[idx]));
                q.add(node.right);
            }
        }
        return root;
    }
}
