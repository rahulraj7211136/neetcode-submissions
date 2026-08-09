class Solution {
    public int leastInterval(char[] tasks, int n) {
        int i, size = tasks.length;
        int[] freq = new int[26];
        for(char c : tasks) {
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int min = freq[25] - 1;
        int idle = min * n;
        for(i = 24; i>=0;i--) {
            idle -= Math.min(min, freq[i]);
        }
        return idle<0 ? size : size + idle;
    }
}
