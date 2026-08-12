class Solution {
    class Node {
        int idx;
        int inTime;
        int processTime;
        Node(int idx, int inTime, int processTime) {
            this.idx = idx;
            this.inTime = inTime;
            this.processTime = processTime;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int i,n = tasks.length;
        Node[] arr = new Node[n];
        for(i=0;i<n;i++) {
            arr[i] = new Node(i, tasks[i][0], tasks[i][1]);
        }
        Arrays.sort(arr, (a,b) -> {
            if(a.inTime == b.inTime) {
                return a.idx - b.idx;
            }
            return a.inTime - b.inTime;
        });
        PriorityQueue<Node>q = new PriorityQueue<>((a,b) -> {
            if(a.processTime == b.processTime) {
                return a.idx - b.idx;
            }
            return a.processTime - b.processTime;
        });
        int[] ans = new int[n];
        int j=0, currentTime = 0;
        // ans[0] = arr[0].idx;
        i=0;
        while (i < n || !q.isEmpty()) {

            if (q.isEmpty()) {
                currentTime = Math.max(currentTime, arr[i].inTime);
            }
            while (i < n && arr[i].inTime <= currentTime) {
                q.offer(arr[i++]);
            }
            Node task = q.poll();

            ans[j++] = task.idx;

            currentTime += task.processTime;
        }
        return ans;
    }
}