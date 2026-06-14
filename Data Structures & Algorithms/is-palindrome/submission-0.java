class Solution {
    private boolean check(char c) {
        return (c >= 'A' && c<='Z') || (c>='0' && c<='9');
    }
    private boolean same(char a, char b) {
        return a==b;
    }
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        int i=0, j = s.length()-1;
        while(i<=j) {
            while(i<=j && !check(s.charAt(i))) {
                i++;
            }
            while(i<=j && !check(s.charAt(j))) {
                j--;
            }
            if(i<=j && !same(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
