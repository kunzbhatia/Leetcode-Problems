class Solution 
{
    public int numDistinctRecur(int i,int j,char[] str1, char[] str2,int[][]dp) 
    {
        if(j<0) return 1; //matching done as t exhaust
        if(i<0) return 0; //s string exhaust not found

        if(dp[i][j]!=-1) return dp[i][j];

        if(str1[i]==str2[j])
        {
            return dp[i][j]=numDistinctRecur(i-1,j-1,str1,str2,dp)+numDistinctRecur(i-1,j,str1,str2,dp);
        }
        else
        {
            return dp[i][j]=numDistinctRecur(i-1,j,str1,str2,dp);
        }
    }

    public int numDistinct(String s, String t) 
    {
        char[] str1=s.toCharArray();
        char[] str2=t.toCharArray();

        int n=s.length();
        int m=t.length();

        int[][]dp=new int[n+1][m+1];

        for(int[] row: dp)
        {
            Arrays.fill(row,0);
        }

        for(int i=0;i<n;i++) dp[i][0]=1;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {

                if(str1[i-1]==str2[j-1])
                {
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];

    }
}