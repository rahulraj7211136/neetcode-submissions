class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int j=0, ans=0, max=0;
        for(int i=0;i<s.length();i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
            max = Math.max(max, freq.get(s.charAt(i)));
            while(j<i && max + k < i-j+1) {
                freq.put(s.charAt(j), freq.get(s.charAt(j)) - 1);
                j++;
            }
            ans = Math.max(ans, i-j+1);
        }
        
        return ans;
    }
}
