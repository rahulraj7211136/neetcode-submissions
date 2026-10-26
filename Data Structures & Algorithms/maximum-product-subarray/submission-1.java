class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0], i,j,n = nums.length;
        int max = nums[0], min = nums[0];
        for(i=1;i<n;i++) {
            int x = Math.max(nums[i], Math.max(max*nums[i], min*nums[i]));
            int y = Math.min(nums[i], Math.min(max*nums[i], min*nums[i]));
            ans = Math.max(ans, x);
            max = x;
            min = y;
        }
        return ans;
    }
}
