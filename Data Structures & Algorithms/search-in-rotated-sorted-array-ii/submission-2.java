class Solution {
    public boolean search(int[] nums, int target) {
        int s=0, e = nums.length-1;
        while(s <= e) {
            int mid = (s+e)/2;
            if(target == nums[mid]) return true;
            if(nums[s] == nums[mid] && nums[mid] == nums[e]) {
                e--;
                s++;
                continue;
            } 
            if(nums[s] <= nums[mid]) {
                if(nums[s] <= target && target <= nums[mid]) {
                    e = mid-1;
                } else {
                    s = mid+1;
                }
            } else {
                if(nums[mid]<=target && nums[e] >= target) {
                    s = mid+1;
                } else {
                    e = mid-1;
                }
            }
        }
        return false;
    }
}