class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> freq = new HashMap<>();
        int i, n = nums.length;
        for(i=0;i<n;i++) {
            if(freq.containsKey(nums[i])) {
                return true;
            }
            freq.put(nums[i], true);
        }
        return false;
    }
}