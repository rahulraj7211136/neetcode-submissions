class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            s.add(nums[i]);
        } 
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            int x = nums[i];
            int c = 0; 
            if(s.contains(x-1)) {
                continue;
            }
            while(s.contains(x)) {
                c++;
                s.remove(x);
                x = x+1;
            }
            ans = Math.max(ans, c);
        }
        return ans;
    }
}
