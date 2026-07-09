class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int i,n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer>s = new Stack<>();
        for(i=n-1;i>=0;i--) {
            while(!s.empty() && temperatures[s.peek()]<=temperatures[i]) {
                s.pop();
            }
            ans[i] = s.empty() ? 0 : s.peek() - i;
            s.push(i);
        }
        return ans;
    }
}
