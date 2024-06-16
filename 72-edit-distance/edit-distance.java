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

        int[][] dp=new int[n][m];

        for(int[] row: dp)
        {
            Arrays.fill(row,-1);
        }

        return minDistanceRecur(n-1,m-1,str1,str2,dp);


    }
}