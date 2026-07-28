/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    class Node {
        public int val;
        public ListNode list;
        Node(int val, ListNode l) {
            this.val = val;
            this.list = l;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(0), temp = ans;
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.val - b.val);
        int n = lists.length,i;
        for(i=0;i<n;i++) {
            if(lists[i] == null) {
                continue;
            }
            q.add(new Node(lists[i].val, lists[i].next));
        }
        while(q.size()>0) {
            Node top = q.poll();
            ListNode t = new ListNode(top.val);
            temp.next = t;
            temp = t;
            if(top.list != null) {
                q.add(new Node(top.list.val, top.list.next));
            } 
        }
        return ans.next;
    }
}
