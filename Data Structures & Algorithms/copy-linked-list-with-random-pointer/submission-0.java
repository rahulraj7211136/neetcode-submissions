/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = head;
        while(temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }
        temp = head;
        while(temp != null && temp.next != null) {
            if (temp.random != null) temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        Node ans = head.next;
        temp = head;
        Node temp1 = head.next;
        while(temp != null && temp.next != null) {
            Node copy = temp.next;

            temp.next = copy.next;

            if (copy.next != null)
                copy.next = copy.next.next;

            temp = temp.next;
        }
        return ans;
    }
}
