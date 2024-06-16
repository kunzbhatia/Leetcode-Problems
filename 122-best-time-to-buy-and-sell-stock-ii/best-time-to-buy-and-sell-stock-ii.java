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

        int[][]dp=new int[days][2];

        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }

        return maxProfitRecur(0,1,prices,dp);
        
    }
}