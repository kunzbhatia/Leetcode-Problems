class Solution 
{
    public int minDistanceRecur(int i,int j,char[] word1, char[] word2,int[][]dp) 
    {
        if(i<0) return j+1; //itne operation karne padege to insert in s1
        if(j<0) return i+1; //itne operation to delete s1

        if(dp[i][j]!=-1) return dp[i][j];

        //Match
        if(word1[i]==word2[j]) return dp[i][j]=0+minDistanceRecur(i-1,j-1,word1,word2,dp);
        //Unmatch
        int insert= 1+ minDistanceRecur(i,j-1,word1,word2,dp);
        int delete= 1+ minDistanceRecur(i-1,j,word1,word2,dp);
        int replace= 1+ minDistanceRecur(i-1,j-1,word1,word2,dp);
        
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }

    public int minDistance(String word1, String word2) 
    {
        int n=word1.length();
        int m=word2.length();

        char[] str1=word1.toCharArray();
        char[] str2=word2.toCharArray();

        int[][] dp=new int[n+1][m+1];

        for(int[] row: dp)
        {
            Arrays.fill(row,0);
        }

        for(int i=0;i<=n;i++) dp[i][0]=i;
        for(int j=0;j<=m;j++) dp[0][j]=j;

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(str1[i-1]==str2[j-1]) 
                dp[i][j]=0 + dp[i-1][j-1];
                //Unmatch
                else
                dp[i][j]=1+ Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
            }
        }

        return dp[n][m];


    }
}