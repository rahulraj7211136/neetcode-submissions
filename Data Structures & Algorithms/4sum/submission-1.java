class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int i,j,k,n = nums.length;
        Arrays.sort(nums);
        HashSet<ArrayList<Integer>>s = new HashSet<>();
        for(i=0;i<n-3;i++) {
            for(j=i+1;j<n-2;j++) {
                k = j+1;
                int x = n-1;
                while(k<x) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k] + (long)nums[x];
                    if(sum == target) {
                        s.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[x])));
                        k++;
                        x--;
                    } else if(sum > target) {
                        x--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return new ArrayList<>(s);
    }
}