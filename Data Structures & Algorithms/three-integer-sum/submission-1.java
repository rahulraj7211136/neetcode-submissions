class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> s = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-2;i++) {
            int j = i+1, k = n-1;
            while(j<k) {
                int x = nums[i] + nums[j] + nums[k];
                if(x == 0) {
                    s.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k])));
                    j++;
                } else if(x > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        List<List<Integer>>ans = new ArrayList<>(s);
        return ans;
    }
}
