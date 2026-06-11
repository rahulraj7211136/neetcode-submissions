class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int fcount = 0, scount = 0, f=-1, s=-1;
        for(int i=0;i<nums.length;i++) {
            int x = nums[i];
            if(x == f) {
                fcount++;
            } else if(x == s) {
                scount++;
            } else if(fcount == 0) {
                f = x;
                fcount = 1;
            } else if(scount == 0) {
                s = x;
                scount = 1;
            } else {
                fcount--;
                scount--;
            }
        }
        fcount = scount = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == f) fcount++;
            else if(nums[i] == s)scount++;
        }
        List<Integer> ans = new ArrayList<>();
        if(fcount > nums.length/3)ans.add(f);
        if(scount > nums.length/3)ans.add(s);
        return ans;
    }
}