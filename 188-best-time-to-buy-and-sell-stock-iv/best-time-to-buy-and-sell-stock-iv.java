class Solution {
    public int maxProfit(int k,int[] prices) 
    {
         int days=prices.length;
         int profit=0;
        //  int[][] dp=new int[days+1][2*k+1];
        int[] after=new int[2*k+1];
        int[] curr=new int[2*k+1];
        Arrays.fill(after,0);
        Arrays.fill(curr,0);


        //  for(int[][] rr:dp)
        //  {
        //      for(int[] row:rr)
        //      {
        //         Arrays.fill(row,0);
        //      }
        //  }

        // for(int[] row: dp)
        //     {
        //         Arrays.fill(row,0);
        //     }

         for (int i=days-1;i>=0;i--)
         {
            // for(int j=0;j<=1;j++)
            // {
                for(int f=1;f<=2*k;f++)
                {
                    if(f%2==0)
                    {
                        profit=Math.max(-prices[i]+after[f-1],0+after[f]);
                    }


                    else
                    {
                        profit=Math.max(prices[i]+after[f-1],0+after[f]);
                    }

                    curr[f]=profit;
            }
            after=curr;
         }

         return after[2*k];
        
    }
}
