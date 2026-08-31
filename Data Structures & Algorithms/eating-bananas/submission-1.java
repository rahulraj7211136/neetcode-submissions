class Solution {
    private boolean check(long mid, int[] piles, long n,int h) {
        long hour = 0;
        for(int i=0;i<n;i++) {
            hour += piles[i]/mid + ((piles[i]%mid == 0) ? 0 : 1);
        }
        return (int)hour<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        long s=1, e = 0, n = piles.length, ans =-1;
        for(int i=0;i<n;i++)  {
            e+=piles[i];
        }
        while(s<=e) {
            long mid = (s+e)/2;
            if(check(mid,piles,n,h)) {
                ans = mid;
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return (int)ans;
    }
}
