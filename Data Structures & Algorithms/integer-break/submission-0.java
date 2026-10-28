class Solution {
    static int[] dp = new int[60];
    private int solve(int n) {
        if(n<=1) return n;
        if(dp[n] != -1)return dp[n];
        int ans=0;
        for(int i=1;i<=n/2;i++) {
            ans = Math.max(ans, i * Math.max(n-i, solve(n-i)));
        }
        return dp[n] = ans;
    }
    public int integerBreak(int n) {
        Arrays.fill(dp, -1);
        return solve(n);
    }
}