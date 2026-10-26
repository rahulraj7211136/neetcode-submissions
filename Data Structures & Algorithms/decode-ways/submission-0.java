class Solution {
    private int val(int a) {
        if(a==0)return 0;
        return 1;
    }
    private int val(int a, int b) {
        int x = a*10 + b;
        if(x>=10 && x<=26) {
            return 1;
        }
        return 0;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = val(s.charAt(0)-'0');
        for(int i=2;i<=n;i++) {
            int a = s.charAt(i-1)-'0';
            int b = s.charAt(i-2)-'0';
            dp[i] = dp[i-1] * val(a);
            dp[i] += dp[i-2] * val(b,a);
        }
        return dp[n];
    }
}
