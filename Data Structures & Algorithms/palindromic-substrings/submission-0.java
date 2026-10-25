class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.equals(""))return 0;
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for(int i=0;i<s.length();i++) {
            sb.append(s.charAt(i)).append("#");
        }
        String t = sb.toString();
        int n = t.length();
        int[] dp = new int[n];
        int right = 0, centre=0;
        for(int i=0;i<t.length();i++) {
            int mirror = 2*centre-i;
            if(i < right) {
                dp[i] = Math.min(right-i, dp[mirror]);
            }
            while(i+dp[i]+1 < n && i-dp[i]-1 >= 0 && t.charAt(i+dp[i]+1) == t.charAt(i-dp[i]-1)) {
                dp[i]++;
            }
            if(i + dp[i] > right) {
                centre = i;
                right = i+dp[i];
            }
        }
        int ans=0;
        for(int i=0;i<n;i++) {
            ans += (dp[i]+1)/2;
        }
        return ans;
    }
}
