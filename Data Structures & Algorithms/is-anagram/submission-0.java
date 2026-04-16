class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int i, n = s.length();
        int []sc = new int[26];
        int []tc = new int[26];
        for(i=0;i<n;i++) {
            sc[s.charAt(i) - 'a']++;
            tc[t.charAt(i) - 'a']++;
        }
        for(i=0;i<26;i++) {
            if(sc[i] != tc[i])return false;
        }
        return true;
    }
}
