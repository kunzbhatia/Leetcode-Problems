class Solution {
    public int maxOperations(String s) {
        int n = s.length(), cnt = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ans += cnt;
                while (i < n && s.charAt(i) != '1') {
                    i++;
                }
            }
            cnt++;
        }
        return ans;
    }
}