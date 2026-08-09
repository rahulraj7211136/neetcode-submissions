class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capitals) {
        int i, n = profits.length;
        Integer[][] arr = new Integer[n][2];
        for(i=0;i<n;i++) {
            arr[i][0] = capitals[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (Integer[]a, Integer[] b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        i=0;
        PriorityQueue<Integer[]>q = new PriorityQueue<>((a,b) -> {
            return b[1] - a[1];
        });
        while(i<n && k > 0) {
            while(i<n && w >= arr[i][0]) {
                q.add(arr[i++]);
            }
            if(!q.isEmpty()) {
                w += q.poll()[1];
                k--;
            } else {
                break;
            }
        }
        while(!q.isEmpty() && k-- > 0) {
            w += q.poll()[1];
        }
        return w;
    }
}