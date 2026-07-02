class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0, n = nums.length, j=1;
        Deque<Integer> q = new ArrayDeque<>();
        while(i<k) {
            while(!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            i++;
        }
        int [] ans = new int[n-k+1];
        ans[0] = nums[q.getFirst()];
        while(i<n) {
            while(!q.isEmpty() && i-k >= q.getFirst()) {
                q.removeFirst();
            }
            while(!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            ans[j++] = nums[q.getFirst()];
            i++;
        }
        return ans;
    }
}
