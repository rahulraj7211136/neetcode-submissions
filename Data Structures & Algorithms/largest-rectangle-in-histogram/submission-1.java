class Solution {
    public int largestRectangleArea(int[] heights) {
        int i = 0, n = heights.length, ans = 0;
        Stack<Integer> s = new Stack<>();
        for(i=0;i<n;i++) {
            while(!s.empty() && heights[s.peek()] >= heights[i]) {
                int top = heights[s.pop()];
                int width;
                if(s.empty()) {
                    width = i;
                } else {
                    width = i - s.peek() - 1;
                }
                // System.out.println(top + " " + width + " " + top*width);
                ans = Math.max(ans, top * width);
            }
            s.push(i);
        }
        while(!s.empty()) {
            int top = heights[s.pop()];
            int width;
            if(s.empty()) {
                width = n;
            } else {
                width = n - s.peek() - 1;
            }
            // System.out.println(top + " " + width + " " + top*width);
            ans = Math.max(ans, top * width);
        }
        return ans;
    }
}
