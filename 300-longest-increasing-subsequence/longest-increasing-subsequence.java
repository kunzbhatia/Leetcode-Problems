class Solution 
{
    public int lengthOfLISRecur(int i,int prev,int[] nums,int[][]dp) 
    {
        if(i==nums.length) return 0;

        if(dp[i][prev+1]!=-1) return dp[i][prev+1];

        //NOTTAKE
        int nottake=0+lengthOfLISRecur(i+1,prev,nums,dp);
        //TAKE
        int take=Integer.MIN_VALUE;
        if(prev==-1 || nums[i]>nums[prev])
        {
            take=1+lengthOfLISRecur(i+1,i,nums,dp);
        }

        return dp[i][prev+1]=Math.max(take,nottake);

        

        
    }
    public int lengthOfLIS(int[] nums) 
    {
        int n=nums.length;

        // int[][]dp=new int[n][n+1];
        int[][]dp=new int[n+1][n+1];

        for(int [] row:dp)
        {
            Arrays.fill(row,0);
        }

        for(int i=n-1;i>=0;i--)
        {
            for(int j=i-1;j>=-1;j--)
            {
                int nottake=0+dp[i+1][j+1];
                //TAKE
                int take=Integer.MIN_VALUE;
                if(j==-1 || nums[i]>nums[j])
                {
                    take=1+dp[i+1][i+1];
                }

                dp[i][j+1]=Math.max(take,nottake);

            }
        }

        return dp[0][-1+1];

    }
}