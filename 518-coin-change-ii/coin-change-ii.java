class Solution {

    public int changerecur(int n,int amount, int[] coins,int[][]dp) 
    {
        if(n==0)
        {
            if(amount%coins[n]==0)
            return 1;
            else
            return 0;
        }

        if(dp[n][amount]!=-1) return dp[n][amount];

        int nottake=0+changerecur(n-1,amount,coins,dp);
        int take=0;
        if(coins[n]<=amount) take=changerecur(n,amount-coins[n],coins,dp);


        dp[n][amount]=take+nottake;
        return dp[n][amount];


    }

    public int change(int amount, int[] coins) 
    {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];

        for (int row[] : dp) 
        {
            Arrays.fill(row, -1);
        }

        return changerecur(n-1,amount,coins,dp);
        
    }
}