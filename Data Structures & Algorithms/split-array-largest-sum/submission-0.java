class Solution {
    private boolean check(int[] nums, int k, int mid) {
        int s = 0, c = 1;
        for(int i=0;i<nums.length;i++) {
            if(s + nums[i] > mid) {
                s = nums[i];
                c++;
            } else {
                s += nums[i];
            }
        }
        return c<=k;
    }
    public int splitArray(int[] nums, int k) {
        int s=0, e = 0, ans=-1;
        for(int i=0;i<nums.length;i++) {
            e += nums[i];
            s = Math.max(s, nums[i]);
        }
        while(s<=e) {
            int mid = (s+e)/2;
            if(check(nums, k, mid)) {
                ans = mid;
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return ans;
    }
}