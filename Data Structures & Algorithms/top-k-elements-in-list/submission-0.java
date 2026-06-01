class Pair {
    int key;
    int value;
    Pair(int k, int v) {
        this.key = k;
        this.value = v;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Pair>q = new PriorityQueue<>((a,b) -> 
        b.value == a.value ? a.key-b.key : a.value - b.value);
        for(Map.Entry<Integer,Integer> x : freq.entrySet()) {
            int key = x.getKey();
            int value = x.getValue();
            q.add(new Pair(key, value));
            while(q.size() > k) {
                q.poll();
            }
        }
        int[] ans = new int[k];
        int i=0;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            ans[i++] = p.key;
        }
        return ans;
    }
}
