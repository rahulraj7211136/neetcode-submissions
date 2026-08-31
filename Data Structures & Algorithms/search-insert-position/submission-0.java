class Solution {
    public int searchInsert(int[] nums, int target) {
        int mid, s = 0, e = nums.length-1, ans = 0;
        if(nums[e] < target)return e + 1;
        while(s <= e) {
            mid = (s+e)/2;
            if(nums[mid] < target) {
                s = mid+1;
            } else {
                e = mid-1;
                ans = mid;
            }
        }
        return ans;
    }
}