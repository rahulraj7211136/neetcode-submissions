class Solution {
    private void reverse(int s, int e, int[] a) {
        while(s<e) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }
    public void rotate(int[] nums, int k) {
        int i,n = nums.length;
        k %= n;
        reverse(0,n-1,nums);
        reverse(0,k-1,nums);
        reverse(k,n-1,nums);
    }
}