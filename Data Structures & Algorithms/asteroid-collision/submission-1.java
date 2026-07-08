class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int i,n = asteroids.length;
        Stack<Integer> s = new Stack<>();
        for(i=0;i<n;i++) {
            int next = asteroids[i];
            boolean flag = true;
            while(!s.empty() && s.peek() > 0 && next < 0) {
                int top = s.peek();
                if(top<0)break;
                if(top + next == 0) {
                    flag = false;
                    s.pop();
                    break;
                } else if(top + next < 0) {
                    s.pop();
                } else {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                s.push(next);
            }
        }
        int []ans = new int[s.size()];
        i=0;
        int m = s.size();
        while(!s.empty()) {
            ans[i++] = s.pop();
        }
        for(i=0;i<m/2;i++) {
            int t = ans[i];
            ans[i] = ans[m-1-i];
            ans[m-1-i] = t;
        }
        return ans;
    }
}