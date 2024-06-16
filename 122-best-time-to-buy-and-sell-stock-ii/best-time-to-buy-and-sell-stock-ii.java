class Solution 
{
    public int maxProfitRecur(int i, int buy ,int[] prices,int [][]dp) 
    {
        if(i==prices.length) return 0;
        int profit=0;

        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1)
        {
            profit=Math.max(-prices[i]+maxProfitRecur(i+1,0,prices,dp),0+maxProfitRecur(i+1,1,prices,dp));
        }


        else
        {
            profit=Math.max(prices[i]+maxProfitRecur(i+1,1,prices,dp),0+maxProfitRecur(i+1,0,prices,dp));
        }

        return dp[i][buy]=profit;

    }
    public int maxProfit(int[] prices) 
    {
        int days=prices.length;
        int profit=0;
        // int[][]dp=new int[days+1][2];
        int[] ahead=new int[2];
        int[] curr=new int[2];

        Arrays.fill(ahead,0);
        Arrays.fill(curr,0);

        // for(int[] row:dp)
        // {
        //     Arrays.fill(row,0);
        // }

        ahead[0]=0;
        ahead[1]=0;

        for(int i=days-1;i>=0;i--)
        {
            for(int j=0;j<=1;j++)
            {
                if(j==1)
                {
                    profit=Math.max(-prices[i]+ahead[0],0+ahead[1]);
                }


                else
                {
                    profit=Math.max(prices[i]+ahead[1],0+ahead[0]);
                }

                curr[j]=profit;
            }
            ahead=curr;
        }

        return ahead[1];
        
    }
}