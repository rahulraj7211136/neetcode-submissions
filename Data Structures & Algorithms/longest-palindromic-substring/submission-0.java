class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for(int i=0;i<s.length();i++) {
            sb.append(s.charAt(i)).append("#");
        }
        int centre=0, right=0, max=0, idx = 0;
        String t = sb.toString();
        int n = t.length();
        int[] dp = new int[n];
        for(int i=0;i<n;i++) {
            int mirror = 2*centre - i;
            if(i < right) {
                dp[i] = Math.min(right - i, dp[mirror]);
            }
            while(i+dp[i]+1 < n && i-dp[i]-1 >= 0 && t.charAt(i-dp[i]-1) == t.charAt(i+dp[i]+1)) {
                dp[i]++;
            }
            if(i + dp[i] > right) {
                right = i + dp[i];
                centre = i;
            }
            if(dp[i] > max) {
                max = dp[i];
                idx = i;
            }
        }
        int x = (idx - max)/2;
        return s.substring(x, x+max);
    }
}
