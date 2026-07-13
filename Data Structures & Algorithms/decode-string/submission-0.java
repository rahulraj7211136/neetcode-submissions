class Solution {
    public String decodeString(String s) {
        Stack<Integer>ints = new Stack<>();
        Stack<String>strs = new Stack<>();
        int i=0, n = s.length();
        while(i<n) {
            StringBuilder sb = new StringBuilder();
            if(s.charAt(i) == ']') {
                while(!strs.empty() && !strs.peek().equals("[")) {
                    sb.insert(0,strs.pop());
                }
                if(!strs.empty() && strs.peek().equals("[")) {
                    strs.pop();
                }
                int times = 0;
                if(!ints.empty()) {
                    times = ints.pop();
                }
                String temp = sb.toString();
                for(int j=1;j<times;j++) {
                    sb.append(temp);
                }
                strs.push(sb.toString());
                i++;
                continue;
            }
            sb.setLength(0);
            while(i<n && s.charAt(i)>='0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i++));
            }
            String intstr = sb.toString();
            if(!intstr.equals(""))ints.push(Integer.parseInt(intstr));
            if(i<n && s.charAt(i) == '[') {
                strs.push("[");
                i++;
            }
            sb.setLength(0);
            while(i<n && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                sb.append(s.charAt(i++));
            }
            String p = sb.toString();
            if(!p.equals(""))strs.push(p);
        }
        StringBuilder sb1  = new StringBuilder();
        while(!strs.empty()) {
            sb1.insert(0,strs.pop());
        }
        return sb1.toString();
    }
}