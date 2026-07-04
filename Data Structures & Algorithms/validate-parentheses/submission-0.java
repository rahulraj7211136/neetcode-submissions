class Solution {
    public boolean isValid(String s) {
        Stack<Character>st = new Stack<>();
        int i,n = s.length();
        for(i=0;i<n;i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(st.empty() || st.peek() != '(') {
                    return false;
                }
                st.pop();
            } else if(c == '}') {
                if(st.empty() || st.peek() != '{') {
                    return false;
                }
                st.pop();
            } else if(c == ']') {
                if(st.empty() || st.peek() != '[') {
                    return false;
                }
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.empty() ? true : false;
    }
}
