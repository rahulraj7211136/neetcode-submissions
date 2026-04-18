class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for(String s : strs) {
            int [] freq = new int[26];
            for(int i=0;i<s.length();i++) {
                freq[s.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++) {
                sb.append(freq[i]).append("#");
            }

            mp.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}
