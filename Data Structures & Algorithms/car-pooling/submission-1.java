class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int i=0, n = trips.length, people = 0, inTime=0;
        PriorityQueue<Integer[]> q = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        while(i<n) {
            people += trips[i][0];
            inTime = trips[i][1];
            q.add(new Integer[] {trips[i][0], trips[i][1], trips[i][2]});
            i++;
            while(!q.isEmpty() && inTime >= q.peek()[2]) {
                people -= q.poll()[0];
            }
            if(people > capacity) return false;
        }
        return true;
    }
}