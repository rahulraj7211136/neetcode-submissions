class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++) {
            sb.append(strs.get(i).length()).append("#").append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0, n = str.length();
        List<String> ans = new ArrayList<>();
        while(i<n) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            ans.add(str.substring(j+1, j+1+len));
            i = j+1+len;
        }
        return ans;
    }
}
