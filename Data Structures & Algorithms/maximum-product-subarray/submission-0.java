class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        int i,n = nums.length;
        for(i=1;i<n;i++) {
            int x = Math.max(nums[i], Math.max(max * nums[i], min* nums[i]));
            int y = Math.min(nums[i], Math.min(max * nums[i], min* nums[i]));
            max = x;
            min = y;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
