class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] a = new int[256];
        Arrays.fill(a, 0);
        int i=0,j=0,n = s.length(), ans = 0;
        while(j<n) {
            int x = s.charAt(j) - '\0';
            a[x]++;
            while(i<j && a[x] > 1) {
                a[s.charAt(i++)-'\0']--;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}
