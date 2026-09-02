class TimeMap {
    class Pair {
        public Integer first;
        public String second;
        Pair(Integer time, String val) {
            this.first = time;
            this.second = val;
        }
    }
    HashMap<String, ArrayList<Pair>>mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.computeIfAbsent(key, (k -> new ArrayList<>())).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)) {
            return "";
        }
        ArrayList<Pair> list = mp.get(key);
        int s=0, e = list.size() - 1;
        int idx = -1;
        while(s<=e) {
            int mid = (s+e)/2;
            Pair x = list.get(mid);
            if(x.first <= timestamp) {
                s = mid+1;
                idx = mid;
            } else {
                e = mid-1;
            }
        }
        if (idx == -1) {
            return "";
        }
        return list.get(idx).second;
    }
}
