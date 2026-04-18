class Solution {
    public int majorityElement(int[] nums) {
        int me = -1, c=0,i, n = nums.length;
        for(i=0;i<n;i++) {
            if(c==0) {
                me = nums[i];
            }
            if(nums[i] == me) {
                c++;
            } else {
                c--;
            }
        }
        return me;
    }
}