class Solution {
    public int maxProfit(int[] prices) {
        int i,n = prices.length,m = prices[0], ans = 0;
        for(i=1;i<n;i++) {
            ans = Math.max(ans, prices[i] - m);
            m = Math.min(m, prices[i]);
        }
        return ans;
    }
}
