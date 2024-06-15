class Solution 
{
    public int coinChangerecur(int n, int amount,int[] coins,int[][]dp) 
    {
        if(n==0)
        {
            if(amount%coins[n]==0)
            return amount/coins[n];
            else 
            return 10000000 ;
        }

        if(dp[n][amount]!=-1) return dp[n][amount];

        int nottake=0+coinChangerecur(n-1,amount,coins,dp);
        int take=10000000;
        if(coins[n]<=amount) take=1+coinChangerecur(n,amount-coins[n],coins,dp);

        dp[n][amount]=Math.min(take,nottake);
        return dp[n][amount];
    }
    public int coinChange(int[] coins, int amount) 
    {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int ans=coinChangerecur(n-1,amount,coins,dp);
        if(ans==10000000) return -1;
        else return ans;
        
    }
}