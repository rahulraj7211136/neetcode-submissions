class Solution {
public:

    string encode(vector<string>& strs) {
        string ans = "";
        for(string s:strs) {
            ans += to_string(s.length());
            ans += "#";
            ans += s;
        }
        return ans;
    }

    vector<string> decode(string s) {
        int i=0, n = s.length();
        vector<string>ans;
        while(i<n) {
            int j = i;
            while(s[j] != '#') {
                j++;
            }
            int len = stoi(s.substr(i,j));
            ans.push_back(s.substr(j+1, len));
            i = j+1+len;
        }
        return ans;
    }
};
