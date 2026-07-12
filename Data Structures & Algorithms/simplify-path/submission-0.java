class Solution {
    public String simplifyPath(String path) {
        Stack<String>s = new Stack<>();
        for(int i=0;i<path.length();i++) {
            if(path.charAt(i) == '/') continue;
            StringBuilder sb = new StringBuilder();
            while(i<path.length() && path.charAt(i) != '/') {
                sb.append(path.charAt(i++));
            }
            String t = sb.toString();
            if(t.equals(".")) {
                continue;
            } else if(t.equals("..")) {
                if(!s.empty()) s.pop();
            } else {
                s.push(t);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        s.forEach(x -> sb.append(x).append('/'));
        String ans = sb.toString();
        return s.empty() ? ans : ans.substring(0, ans.length()-1);
    }
}