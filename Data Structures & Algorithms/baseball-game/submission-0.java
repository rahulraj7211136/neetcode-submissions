class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        int i,n = operations.length;
        for(i=0;i<n;i++) {
            String t = operations[i];
            if(t.equalsIgnoreCase("+")) {
                int a = s.pop();
                int b = s.peek();
                s.push(a);
                s.push(a+b);
            } else if(t.equalsIgnoreCase("C")) {
                s.pop();
            } else if(t.equalsIgnoreCase("D")) {
                int x = s.peek();
                s.push(x*2);
            } else {
                int x = Integer.parseInt(t);
                s.push(x);
            }
        }
        int ans=0;
        while(!s.empty()) {
            ans += s.pop();
        }
        return ans;
    }
}