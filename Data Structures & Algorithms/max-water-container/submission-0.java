class Solution {
    public int maxArea(int[] heights) {
        int s=0, e=heights.length - 1, ans = 0;
        while(s<e) {
            if(heights[s] > heights[e]) {
                ans = Math.max(ans, heights[e]*(e-s));
                e--;
            } else {
                ans = Math.max(ans, heights[s]*(e-s));
                s++;
            }
        } 
        return ans;
    }
}
