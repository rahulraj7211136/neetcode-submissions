class Solution {
    private int get(Stack<Integer>s) {
        return s.pop();
    }
    private void add(Stack<Integer>s) {
        int f = get(s);
        int p = get(s);
        s.push(f+p);
    }
    private void subtract(Stack<Integer>s) {
        int f = get(s);
        int p = get(s);
        s.push(p-f);
    }
    private void multiply(Stack<Integer>s) {
        int f = get(s);
        int p = get(s);
        s.push(f*p);
    }
    private void divide(Stack<Integer>s) {
        int f = get(s);
        int p = get(s);
        s.push(p/f);
    }
    public int evalRPN(String[] tokens) {
        int i,n = tokens.length;
        Stack<Integer>s = new Stack<>();
        for(i=0;i<n;i++) {
            String t = tokens[i];
            if(t.equals("+")) {
                add(s);
            } else if(t.equals("-")) {
                subtract(s);
            } else if(t.equals("*")) {
                multiply(s);
            } else if(t.equals("/")) {
                divide(s);
            } else {
                s.push(Integer.parseInt(t));
            }
        }
        return s.peek();
    }
}
