class Solution {
    private int solve(int[] nums, int t, int[] dp) {
        if(t<0) return 0;
        if(t==0) return 1;
        if(dp[t] != -1) return dp[t];
        int ans=0;
        for(int i=0;i<nums.length;i++) {
            if(t < nums[i]) break;
            ans += solve(nums, t-nums[i], dp);
        }
        return dp[t] = ans;
    }
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        Arrays.sort(nums);
        solve(nums, target, dp);
        return dp[target];
    }
}