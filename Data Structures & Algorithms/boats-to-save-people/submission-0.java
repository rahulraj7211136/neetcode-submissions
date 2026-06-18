class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int s=0, e= people.length - 1, ans=0;
        Arrays.sort(people);
        while(s<=e) {
            if(people[e] == limit) {
                e--;
                ans++;
                continue;
            }
            int sum = people[s] + people[e];
            if(sum > limit) {
                e--;
            } else {
                s++;
                e--;
            }
            ans++;
        }
        return ans;
    }
}