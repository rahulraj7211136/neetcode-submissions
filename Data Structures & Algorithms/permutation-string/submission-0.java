class Solution {
    private boolean check(int[] count) {
        for(int i=0;i<26;i++) {
            if(count[i]!=0)return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length(), i,j=0;
        if(n>m)return false;
        int [] count = new int[26];
        for(i=0;i<n;i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for(i=0;i<n;i++) {
            count[s2.charAt(i) - 'a']--;
        }
        if(check(count)) {
            return true;
        }
        while(i<m) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(j) - 'a']++;
            if(check(count)) return true;
            i++;
            j++;
        }
        return false;
    }
}
