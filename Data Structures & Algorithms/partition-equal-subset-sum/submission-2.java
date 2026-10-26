class Solution {
    public boolean canPartition(int[] nums) {
        int i,j,sum = 0, n = nums.length;
        for(i=0;i<n;i++) {
            sum += nums[i];
        }
        if(sum%2 == 1) return false;
        sum/=2;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(i=0;i<n;i++) {
            Arrays.fill(dp[i], false);
            dp[i][0] = true;
        }
        for(i=1;i<=n;i++) {
            for(j=1;j<=sum;j++) {
                dp[i][j] = dp[i-1][j];
                if(j - nums[i-1] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
