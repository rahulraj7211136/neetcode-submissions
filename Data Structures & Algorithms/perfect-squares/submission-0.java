class Solution {
    int[] dp;
    int[] nums;
    public int numSquares(int n) {
        nums = new int[105];
        for(int i=0;i<=104;i++) {
            nums[i] = i*i;
        }
        int i,j;
        dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(i=0;i<105;i++) {
            for(j=1;j<=n;j++) {
                if(j-nums[i] >= 0 && dp[j-nums[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-nums[i]]+1);
                }
            }
        }
        return dp[n];
    }
}