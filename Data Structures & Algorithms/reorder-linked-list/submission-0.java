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
    private ListNode reverse(ListNode head) {
        ListNode p=null, c=head, n;
        while(c != null) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)return;
        ListNode s=head, f = head.next;
        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }
        ListNode x = reverse(s.next);
        s.next = null;
        s = head;
        while(s != null && x != null) {
            ListNode tempS = s.next;
            ListNode tempX = x.next;
            s.next = x;
            x.next = tempS;
            s = tempS;
            x = tempX; 
        }
    }
}
