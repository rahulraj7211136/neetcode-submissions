class Solution {
    public int findMin(int[] nums) {
        int s=0, e = nums.length-1, ans = Integer.MAX_VALUE;
        if(nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        while(s<=e) {
            int mid = (s+e)/2;
            if(nums[s] <= nums[mid]) {
                ans = Math.min(ans, nums[s]);
                s = mid+1;
            } else {
                e = mid-1;
                ans = Math.min(ans, nums[mid]);
            }
        }
        return ans;
    }
}
