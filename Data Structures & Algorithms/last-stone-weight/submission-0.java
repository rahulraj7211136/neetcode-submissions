class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>q = new PriorityQueue<>((a,b) -> b-a);
        for(int x : stones) {
            q.add(x);
        }
        while(q.size() > 1) {
            int a = q.poll();
            int b = q.poll();
            if(a != b) {
                q.add(a-b);
            }
        }
        return q.isEmpty() ? 0 : q.poll();
    }
}
