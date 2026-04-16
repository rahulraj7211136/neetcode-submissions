class Solution {
    public int[] getConcatenation(int[] nums) {
        int i,n = nums.length;
        int[] ans = new int[2*n];
        for(i=0;i<2*n;i++) {
            ans[i] = nums[i%n];
        } 
        return ans;
    }
}