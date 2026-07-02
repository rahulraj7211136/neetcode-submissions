class Solution {
    public String minWindow(String s, String t) {
        int i,j=0,n=s.length(),m=t.length(), ans = Integer.MAX_VALUE;
        int[] a = new int[256];
        int [] b = new int[256];
        for(i=0;i<m;i++) {
            b[t.charAt(i)-'\0']++;
        }
        int count=0,idx=-1;
        i=0;
        while(i<n) {
            char c = s.charAt(i);
            a[c-'\0']++;
            if(a[c-'\0'] <= b[c-'\0']) {
                count++;
            }
            if(count == m) {
                while(j<=i && (b[s.charAt(j)-'\0'] == 0 || a[s.charAt(j)-'\0'] > b[s.charAt(j)-'\0'])) {
                    a[s.charAt(j) - '\0']--;
                    j++;
                }
                if(ans > i-j+1) {
                    ans = i-j+1;
                    idx = j;
                }
            }
            i++;
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(idx, idx+ans);
    }
}
