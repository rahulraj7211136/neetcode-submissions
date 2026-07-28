class Solution {
    public int findDuplicate(int[] nums) {
        int i, n = nums.length;
        for(i=0;i<n;i++) {
            int idx = Math.abs(nums[i])-1;
            if(nums[idx] < 0)return idx+1;
            nums[idx] = -nums[idx];
        }
        return -1;
    }
}
