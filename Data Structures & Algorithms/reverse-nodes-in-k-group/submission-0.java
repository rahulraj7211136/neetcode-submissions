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
        ListNode head;
        ListNode tail;
        Node(ListNode h, ListNode t) {
            this.head = h;
            this.tail = t;
        }
    }
    private Node reverse(ListNode head) {
        ListNode t = head, p=null, c=head, n;
        while(c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return new Node(p,t);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = null, p = null;
        while(head != null) {
            int x = k;
            ListNode temp = head;
            while(head != null && x-- > 1) {
                head = head.next;
            }
            if (head == null) {
                if (p == null)
                    ans = temp;
                else
                    p.next = temp;
                break;
            }

            ListNode nextGroup = head.next;
            head.next = null;

            Node r = reverse(temp);

            if (p == null)
                ans = r.head;
            else
                p.next = r.head;

            p = r.tail;
            head = nextGroup;
        }
        return ans;
    }
}
