class KthLargest {
    PriorityQueue<Integer>q;
    int k;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        this.k = k;
        for(int x : nums) {
            q.add(x);
            if(q.size() > k) {
                q.poll();
            }
        }
    }
    
    public int add(int val) {
        q.add(val);
        if(q.size()>k) q.poll();
        return q.peek();
    }
}
