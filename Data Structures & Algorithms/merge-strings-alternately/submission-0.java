class Solution {
    public String mergeAlternately(String s1, String s2) {
        int i=0,j=0, n = s1.length(), m = s2.length();
        StringBuilder sb = new StringBuilder();
        while(i<n && j<m) {
            sb.append(s1.charAt(i++)).append(s2.charAt(j++));
        }
        while(i<n) {
            sb.append(s1.charAt(i++));
        }
        while(j<m) {
            sb.append(s2.charAt(j++));
        }
        return sb.toString();
    }
}