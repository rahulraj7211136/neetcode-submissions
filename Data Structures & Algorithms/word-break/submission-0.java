class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length(),i,j;
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(i = n-1;i>=0;i--) {
            StringBuilder sb = new StringBuilder();
            for(j=i;j<n;j++) {
                sb.append(s.charAt(j));
                if(set.contains(sb.toString())) {
                    dp[i] = dp[i] || dp[j+1];
                }
            }
            // System.out.print(dp[i] + " ");
        }
        return dp[0];
    }
}
