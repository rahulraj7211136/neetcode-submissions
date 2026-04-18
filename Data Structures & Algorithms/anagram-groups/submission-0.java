class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for(String s : strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            String t = new String(a);

            mp.computeIfAbsent(t, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(mp.values());
    }
}
