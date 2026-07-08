class MinStack {
    long min;
    Stack<Long>s;
    public MinStack() {
        min = Integer.MAX_VALUE;
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.empty()) {
            min = val;
            s.push((long)val);
            return;
        }
        if(val < min) {
            long temp = val*2L - min;
            min = val;
            s.push(temp);
        } else {
            s.push((long)val);
        }
    }
    
    public void pop() {
        if(s.empty())return;
        long x = s.pop();
        if(x < min) {
            min = 2L*min - x;
        }
    }
    
    public int top() {
        if(s.empty())return -1;
        long x = s.peek();
        if(x < min) {
            return (int)min;
        }
        return (int)x;
    }
    
    public int getMin() {
        return (int)min;
    }
}
