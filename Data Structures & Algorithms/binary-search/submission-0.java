class Solution {
    public int search(int[] nums, int target) {
        int mid, s = 0, e = nums.length-1;
        while(s<=e) {
            mid = (s+e)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }
}
