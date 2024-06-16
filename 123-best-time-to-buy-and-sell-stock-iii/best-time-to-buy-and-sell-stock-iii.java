class Solution 
{
    public int maxProfitRecur(int i, int buy ,int Tcap,int[] prices,int [][][]dp) 
    {
        if(Tcap==0) return 0;
        if(i==prices.length) return 0;
        int profit=0;

        if(dp[i][buy][Tcap]!=-1) return dp[i][buy][Tcap];
        if(buy==1)
        {
            profit=Math.max(-prices[i]+maxProfitRecur(i+1,0,Tcap,prices,dp),0+maxProfitRecur(i+1,1,Tcap,prices,dp));
        }


        else
        {
            profit=Math.max(prices[i]+maxProfitRecur(i+1,1,Tcap-1,prices,dp),0+maxProfitRecur(i+1,0,Tcap,prices,dp));
        }

        return dp[i][buy][Tcap]=profit;

    }

    public int maxProfit(int[] prices) 
    {
         int days=prices.length;
         int profit=0;
         int[][][]dp=new int[days+1][2][3];

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
                for(int k=1;k<=2;k++)
                {
                    if(j==1)
                    {
                        profit=Math.max(-prices[i]+dp[i+1][0][k],0+dp[i+1][1][k]);
                    }


                    else
                    {
                        profit=Math.max(prices[i]+dp[i+1][1][k-1],0+dp[i+1][0][k]);
                    }

                    dp[i][j][k]=profit;
                }
            }
         }


         return dp[0][1][2];
        
    }
}

// public int maxProfit(int[] prices) 
//     {
//         int days=prices.length;
//         int profit=0;
//         // int[][]dp=new int[days+1][2];

//         // int[] ahead=new int[2];
//         // int[] curr=new int[2];

//         int aheadBuy,aheadNotBuy,currBuy,currNotBuy;
//         aheadBuy=aheadNotBuy=0;

//         // Arrays.fill(ahead,0);
//         // Arrays.fill(curr,0);

//         // for(int[] row:dp)
//         // {
//         //     Arrays.fill(row,0);
//         // }

//         // ahead[0]=0;
//         // ahead[1]=0;

//         for(int i=days-1;i>=0;i--)
//         {
//             currBuy=Math.max(-prices[i]+aheadNotBuy,0+aheadBuy);

//             currNotBuy=Math.max(prices[i]+aheadBuy,0+aheadNotBuy);

//             aheadBuy=currBuy;
//             aheadNotBuy=currNotBuy;
//         }

//         return aheadBuy;
        
//     }