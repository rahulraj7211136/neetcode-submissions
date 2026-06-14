class Solution {
    public int removeDuplicates(int[] nums) {
        int ans = 1, n = nums.length,j=1;
        for(int i=1;i<n;i++) {
            if(nums[i-1] != nums[i]) {
                nums[j++] = nums[i];
                ans++;
            }
        }
        return ans;
    }
}