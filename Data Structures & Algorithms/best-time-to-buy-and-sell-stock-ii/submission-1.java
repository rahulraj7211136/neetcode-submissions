class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0, i;
        for(i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                ans += (Math.abs(prices[i] - prices[i-1]));
            }
        }
        return ans;
    }
}