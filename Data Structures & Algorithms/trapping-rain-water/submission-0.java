class Solution {
    public int trap(int[] height) {
        int n = height.length, ans=0;
        int s=0,e=n-1,sh=height[0], eh = height[e];
        while(s<=e) {
            if(height[s] < height[e]) {
                sh = Math.max(sh, height[s]);
                ans += (sh-height[s++]);
            } else {
                eh = Math.max(eh, height[e]);
                ans += (eh-height[e--]);
            }
        }
        return ans;
    }
}
