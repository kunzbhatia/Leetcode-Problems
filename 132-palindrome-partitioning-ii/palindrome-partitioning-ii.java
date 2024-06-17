class Solution 
{
    public int minCutRecur(int i, String s, int[] dp, boolean[][] isPalindrome) 
    {
        if (i == s.length()) return 0;

        if (dp[i] != -1) return dp[i];
        int mini = 1000000000;
        int cost=0;

        // Partitions
        for (int j = i; j < s.length(); j++) 
        {
            if (isPalindrome[i][j]) 
            {
                cost = 1 + minCutRecur(j + 1, s, dp, isPalindrome);
                mini = Math.min(mini, cost);
            }
        }
        return dp[i] = mini;
    }

    public int minCut(String s) 
    {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Precompute palindromic substrings
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) 
        {
            isPalindrome[i][i] = true; // Single characters are palindromes
        }
        for (int len = 2; len <= n; len++) 
        {
            for (int i = 0; i <= n - len; i++) 
            {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) 
                {
                    if (len == 2) 
                    {
                        isPalindrome[i][j] = true;
                    } 
                    else 
                    {
                        isPalindrome[i][j] = isPalindrome[i + 1][j - 1];
                    }
                }
            }
        }

        return minCutRecur(0, s, dp, isPalindrome) - 1;
    }
}
