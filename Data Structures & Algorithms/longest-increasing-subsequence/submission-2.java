class Solution {
    private int findIndex(int a, List<Integer>v) {
        int s=0, e = v.size()-1, mid, idx=e+1;
        while(s<=e) {
            mid = (s+e)/2;
            if(v.get(mid) >= a) {
                idx = mid;
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return idx;
    }
    public int lengthOfLIS(int[] nums) {
        int i, n = nums.length;
        List<Integer> v = new ArrayList<>();
        for(i=0;i<n;i++) {
            int idx = findIndex(nums[i], v);
            if(idx >= v.size()) {
                v.add(nums[i]);
            } else {
                v.set(idx, nums[i]);
            }
        }
        return v.size();
    }
}
