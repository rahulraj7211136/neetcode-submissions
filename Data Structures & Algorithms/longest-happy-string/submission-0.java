class Solution {
    class Node {
        char c;
        int val;
        Node(char c, int val) {
            this.c = c;
            this.val = val;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        char p = 'z';
        PriorityQueue<Node> q = new PriorityQueue<>((x,y) -> y.val-x.val);
        StringBuilder sb = new StringBuilder();
        if(a>0) q.add(new Node('a', a));
        if(b>0) q.add(new Node('b', b));
        if(c>0) q.add(new Node('c', c));
        while(!q.isEmpty()) {
            Node t = q.poll();
            if(t.c == p) {
                if(q.isEmpty())break;
                Node x = q.poll();
                x.val--;
                p = x.c;
                sb.append(x.c);
                if(x.val != 0) {
                    q.add(new Node(x.c, x.val));
                }
                q.add(t);
            } else {
                int count = t.val;
                if(count == 1) {
                    sb.append(t.c);
                } else {
                    sb.append(t.c).append(t.c);
                    count-=2;
                    if(count != 0) {
                        q.add(new Node(t.c, count));
                    }
                }
                p = t.c;
            }
        }
        return sb.toString();
    }
}