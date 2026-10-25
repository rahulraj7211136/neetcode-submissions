class Solution {
    private int rob1(int[] nums, boolean first, int n) {
        int[] dp = new int[n];
        if(first) {
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for(int i=2;i<n-1;i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
            return dp[n-2];
        }
        dp[1] = nums[1];
        dp[2] = Math.max(nums[2], nums[1]);
        for(int i=3;i<n;i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        int i,n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[1], nums[0]);
        int first = rob1(nums, true, n);
        int second = rob1(nums, false, n);
        return Math.max(first, second);
    }
}
