class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, n = arr.length, r = n-k;
        while(l<r) {
            int mid = (r+l)/2;
            if(x - arr[mid] > arr[mid+k] - x) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=l;i<l+k;i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}