class Solution {
    public int maxProfit(int k,int[] prices) 
    {
         int days=prices.length;
         int profit=0;
         int[][][]dp=new int[days+1][2][k+1];

         for(int[][] rr:dp)
         {
             for(int[] row:rr)
             {
                Arrays.fill(row,0);
             }
         }

         for (int i=days-1;i>=0;i--)
         {
            for(int j=0;j<=1;j++)
            {
                for(int f=1;f<=k;f++)
                {
                    if(j==1)
                    {
                        profit=Math.max(-prices[i]+dp[i+1][0][f],0+dp[i+1][1][f]);
                    }


                    else
                    {
                        profit=Math.max(prices[i]+dp[i+1][1][f-1],0+dp[i+1][0][f]);
                    }

                    dp[i][j][f]=profit;
                }
            }
         }

         return dp[0][1][k];
        
    }
}
