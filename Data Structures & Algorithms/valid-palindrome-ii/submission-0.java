class Solution {
    private boolean check(int i, int j, String s) {
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0, j = s.length()-1;
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)) {
                if(check(i,j-1,s) || check(i+1,j,s)) {
                    return true;
                } else {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }
}