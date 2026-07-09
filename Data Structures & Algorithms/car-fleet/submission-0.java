class Pair {
    public int first;
    public int second;
    Pair(int f, int s) {
        this.first = f;
        this.second = s;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int i, n = position.length;
        ArrayList<Pair>list = new ArrayList<>();
        for(i=0;i<n;i++) {
            list.add(new Pair(position[i], speed[i]));
        }
        list.sort((a,b) -> {return a.first - b.first;});
        double m = 0;
        int ans = 0;
        for(i=n-1;i>=0;i--) {
            double val = ((double)target - (double)list.get(i).first) / list.get(i).second;
            if(m < val) { 
                ans++;
                m = val;
            }
        }
        return ans;
    }
}
