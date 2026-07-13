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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0), temp = head;
        node.next = head;
        while(n-- > 0) {
            temp = temp.next;
        }
        head = node;
        while(temp != null) {
            head = head.next;
            temp = temp.next;
        }
        if(head.next != null)head.next = head.next.next;
        return node.next;
    }
}
