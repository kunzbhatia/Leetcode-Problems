class Solution 
{

    public int LCSrecur(int l1,int l2,char[] text1, char[] text2,int[][]dp) 
    {
        if(l1<0 || l2<0) return 0;

        if(dp[l1][l2]!=-1) return dp[l1][l2];

        //MATCH
        if(text1[l1]==text2[l2]) return dp[l1][l2]= 1 + LCSrecur(l1-1,l2-1,text1,text2,dp);

        //UNMATCH
        return dp[l1][l2]= Math.max(LCSrecur(l1-1,l2,text1,text2,dp),LCSrecur(l1,l2-1,text1,text2,dp));

    }

        
        
    public int longestCommonSubsequence(String text1, String text2) 
    {
        char[] arr1=text1.toCharArray();
        char[] arr2=text2.toCharArray();
        int l1=text1.length();
        int l2=text2.length();

        int [][] dp= new int[l1][l2];
        for(int row[]: dp)
        {
            Arrays.fill(row,-1);
        }

        return LCSrecur(l1-1,l2-1,arr1,arr2,dp);

        
    }
}