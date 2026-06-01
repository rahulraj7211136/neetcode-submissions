class Solution {
    private void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void sortColors(int[] nums) {
        int z=0, o=0, t = nums.length - 1;
        while(o<=t) {
            if(nums[o] == 0) {
                swap(o,z,nums);
                o++;
                z++;
            } else if(nums[o] == 2) {
                swap(o, t, nums);
                t--;
            } else {
                o++;
            }
        }
    }
}