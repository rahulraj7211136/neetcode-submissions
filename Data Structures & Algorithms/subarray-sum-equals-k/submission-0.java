class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0,1);
        int s=0, ans=0;
        for(int x : nums) {
            s += x;
            if(freq.containsKey(s-k)) {
                ans += freq.get(s-k);
            }
            freq.put(s, freq.getOrDefault(s, 0)+1);
        }
        return ans;
    }
}