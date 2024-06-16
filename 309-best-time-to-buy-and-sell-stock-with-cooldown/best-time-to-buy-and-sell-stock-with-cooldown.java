class Solution {
     public int maxProfit(int[] prices) 
    {
        int days=prices.length;
        int profit=0;
        int[][]dp=new int[days+2][2];

        for(int[] row:dp)
        {
            Arrays.fill(row,0);
        }

        dp[days][0]=0;
        dp[days][1]=0;

        for(int i=days-1;i>=0;i--)
        {
            for(int j=0;j<=1;j++)
            {
                if(j==1)
                {
                    profit=Math.max(-prices[i]+dp[i+1][0],0+dp[i+1][1]);
                }


                else
                {
                profit=Math.max(prices[i]+dp[i+2][1],0+dp[i+1][0]);
                }

                dp[i][j]=profit;
            }
        }

        return dp[0][1];
        
    }
}