class Solution 
{
    public boolean isMatchRecur(int i, int j, char[] s, char[] p, int[][] dp) 
    {
        // Base cases
        if (i < 0 && j < 0) return true; // Both strings are exhausted
        if (i >= 0 && j < 0) return false; // Pattern is exhausted but string is not
        if (i < 0 && j >= 0) // String is exhausted but pattern can still have '*'
        {
            for (int k = 0; k <= j; k++) 
            {
                if (p[k] != '*') 
                {
                    return false;
                }
            }
            return true;
        }

        if (dp[i][j] != -1) return dp[i][j] == 1;

        // Match
        if (s[i] == p[j] || p[j] == '?') 
        {
            dp[i][j] = isMatchRecur(i - 1, j - 1, s, p, dp) ? 1 : 0;
            return dp[i][j] == 1;
        }

        // Star match
        if (p[j] == '*') 
        {
            dp[i][j] = (isMatchRecur(i - 1, j, s, p, dp) || isMatchRecur(i, j - 1, s, p, dp)) ? 1 : 0;
            return dp[i][j] == 1;
        }

        // Not match
        dp[i][j] = 0;
        return dp[i][j] == 1;
    }

    public boolean isMatch(String s, String p) 
    {
        int n = s.length();
        int m = p.length();

        char[] str1 = s.toCharArray();
        char[] str2 = p.toCharArray();

        int[][] dp = new int[n + 1][m + 1]; // Size should be (n+1) x (m+1)

        for (int[] row : dp) 
        {
            Arrays.fill(row, -1);
        }

        return isMatchRecur(n - 1, m - 1, str1, str2, dp);
    }
}
