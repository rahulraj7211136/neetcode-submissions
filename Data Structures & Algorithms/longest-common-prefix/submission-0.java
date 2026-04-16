class Trie {
    public Trie[] children;
    public int count;
    Trie() {
        this.count = 1;
        this.children = new Trie[26];
    }
}
class Solution {
    private void insert(Trie root, String s) {
        Trie temp = root;
        for(int i=0;i<s.length();i++) {
            if(temp.children[s.charAt(i)-'a'] != null) {
                temp.count++;
            } else {
                temp.children[s.charAt(i)-'a'] = new Trie();
            }
            temp = temp.children[s.charAt(i)-'a'];
        }
    }
    private String check(Trie root, int n, String s) {
        StringBuilder sb = new StringBuilder();
        int i=0, m = s.length();
        while(i<m && root.children[s.charAt(i) - 'a'] != null) {
            if(root.count == n) {
                sb.append(s.charAt(i));
            } else {
                break;
            }
            root = root.children[s.charAt(i) - 'a'];
            i++;
        }
        return sb.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();
        for(int i=0;i<strs.length;i++) {
            insert(root, strs[i]);
        }
        return check(root, strs.length, strs[0]);
    }
}