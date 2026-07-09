class Pair {
    public int first;
    public int second;
    Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}
class StockSpanner {

    Stack<Pair>s;
    int i;
    public StockSpanner() {
        s = new Stack<>();
        i = 0;
    }
    
    public int next(int price) {
        while(!s.empty() && s.peek().first <= price) {
            s.pop();
        }
        int ans = s.empty() ? i+1 : i - s.peek().second;
        s.push(new Pair(price,i++));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */