class Solution {
    class Node {
        char ch;
        int val;
        Node(char c, int v) {
            this.ch = c;
            this.val = v;
        }
    }
    public String reorganizeString(String s) {
        int i;
        int []freq = new int[26];
        for(i=0;i<s.length();i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> b.val - a.val);
        for(i=0;i<26;i++) {
            if(freq[i] != 0) {
                char c = (char)('a' + i);
                q.add(new Node(c, freq[i]));
            }
        }
        char p = '!';
        while(!q.isEmpty()) {
            Node t = q.poll();
            if(t.ch == p) {
                if(q.isEmpty())return "";
                Node x = q.poll();
                x.val--;
                sb.append(x.ch);
                if(x.val > 0) {
                    q.add(new Node(x.ch, x.val));
                }
                p = x.ch;
                q.add(t);
            } else {
                p = t.ch;
                t.val--;
                sb.append(t.ch);
                if(t.val > 0) {
                    q.add(new Node(t.ch, t.val));
                }
            }
        }
        return sb.toString();
    }
}