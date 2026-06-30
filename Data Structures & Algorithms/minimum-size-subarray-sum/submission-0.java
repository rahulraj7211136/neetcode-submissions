class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int s=0,i=0,j=0,n = nums.length, ans = n+1;
        while(i<n) {
            s += nums[i];
            while(j<=i && s >= target) {
                ans = Math.min(ans, i-j+1);
                s -= nums[j++];
            }
            i++;
        }
        if(ans == n+1)return 0;
        return ans;
    }
}