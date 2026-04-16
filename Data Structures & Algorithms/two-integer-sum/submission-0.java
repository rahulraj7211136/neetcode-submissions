class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int i, n = nums.length;
        for(i=0;i<n;i++) {
            if(mp.containsKey(target-nums[i])) {
                return new int[]{mp.get(target-nums[i]), i};
            }
            mp.put(nums[i], i);
        } 
        return new int[]{};
    }
}
