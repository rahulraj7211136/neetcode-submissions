class Solution {
    public int mySqrt(int x) {
        long s=0,e=x,mid, ans=1;
        while(s<=e) {
            mid = (s+e)/2;
            if(mid*mid<=x) {
                s = mid+1; 
                ans = mid;
            } else {
                e = mid - 1;
            }
        }
        return (int)ans;
    }
}