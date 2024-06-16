class Solution 
{
    public int[][] longestCommonSubsequence(String text1, String text2) 
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

        return dp;   
    }

    public String shortestCommonSupersequence(String str1, String str2) 
    {
        int[][]dp=longestCommonSubsequence(str1,str2);
        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();
        int i=str1.length();
        int j=str2.length();
        StringBuilder ans=new StringBuilder();
        while(i>0 && j>0)
        {
            if(arr1[i-1]==arr2[j-1])
            {
                ans.append(arr1[i-1]);
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1])
            {
                ans.append(arr1[i-1]);
                i--;
            }
            else
            {
                ans.append(arr2[j-1]);
                j--;
            }
        }
        while(i>0) 
        {
            ans.append(arr1[i-1]);
            i--;
        }
        while(j>0) 
        {
            ans.append(arr2[j-1]);
            j--;
        }

        ans.reverse();
        return ans.toString();


    }
}