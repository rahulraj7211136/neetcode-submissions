class Solution {
    private boolean check(long mid, int[] weights, int days, int n) {
        long d = 1, sum = 0;
        for(int i=0;i<n;i++) {
            if(sum + weights[i] > mid) {
                d++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }
        return d<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int i, n = weights.length;
        long s = weights[0], e = 0, ans=0;
        for(i=0;i<n;i++) {
            s = Math.max(s, weights[i]);
            e += weights[i];
        }
        while(s<=e) {
            long mid = (s+e)/2;
            if(check(mid, weights, days, n)) {
                ans = mid;
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return (int)ans;
    }
}