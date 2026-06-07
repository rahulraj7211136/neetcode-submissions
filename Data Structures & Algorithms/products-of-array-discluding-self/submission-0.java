class Solution {
    public int[] productExceptSelf(int[] nums) {
        int i, n = nums.length;
        int [] dp = new int[n];
        dp[0] = 1;
        for(i = 1;i<n;i++) {
            dp[i] = dp[i-1] * nums[i-1];
        }
        int pre = 1;
        for(i = n-1;i>=0;i--) {
            dp[i] *= pre;
            pre *= nums[i]; 
        }
        return dp;
    }
}  
