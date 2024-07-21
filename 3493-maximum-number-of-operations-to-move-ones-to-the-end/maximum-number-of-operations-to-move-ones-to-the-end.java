class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int cnt = 0, i = 0;
        int ans = 0;

        while(i < n) {
            if(s.charAt(i) == '1') {
                cnt++;
                i++;
            }
            else if(s.charAt(i) == '0') {
                while(i < n && s.charAt(i) == '0') {
                    i++;
                }
                ans += cnt;
            }
        }
        return ans;
    }
}