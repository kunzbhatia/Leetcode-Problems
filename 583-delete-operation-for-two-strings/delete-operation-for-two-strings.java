class Solution 
{
    public int longestCommonSubsequence(String text1, String text2) 
    {
        char[] arr1=text1.toCharArray();
        char[] arr2=text2.toCharArray();
        int l1=text1.length();
        int l2=text2.length();

        int [][] dp= new int[l1+1][l2+1];

        for(int row[]: dp)
        {
            Arrays.fill(row,0);
        }

        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l2;j++)
            {
                if(arr1[i-1]==arr2[j-1])
                dp[i][j]= 1 + dp[i-1][j-1];
                else 
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[l1][l2];   
    }
    public int minDistance(String word1, String word2) 
    {
        int lcs=longestCommonSubsequence(word1,word2);
        return word1.length()+word2.length()-2*lcs;
        
    }
}