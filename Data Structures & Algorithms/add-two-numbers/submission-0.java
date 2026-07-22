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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c=0;
        ListNode head = new ListNode(0);
        ListNode temp=head;
        while(l1 != null && l2 != null) {
            int sum = c + l1.val + l2.val;
            ListNode node = new ListNode(sum%10);
            c = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            temp.next = node;
            temp = node;
        }
        while(l1 != null) {
            int sum = c + l1.val;
            ListNode node = new ListNode(sum%10);
            c = sum/10;
            l1 = l1.next;
            temp.next = node;
            temp = node;
        }
        while(l2 != null) {
            int sum = c + l2.val;
            ListNode node = new ListNode(sum%10);
            c = sum/10;
            l2 = l2.next;
            temp.next = node;
            temp = node;
        }
        while(c != 0) {
            ListNode node = new ListNode(c%10);
            temp.next = node;
            temp = node;
            c/=10;
        }
        return head.next;
    }
}
