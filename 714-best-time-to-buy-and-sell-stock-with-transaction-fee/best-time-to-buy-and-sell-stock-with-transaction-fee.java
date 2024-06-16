class Solution {
     public int maxProfit(int[] prices, int fee) 
    {
        int days=prices.length;
        int profit=0;
        // int[][]dp=new int[days+1][2];

        // int[] ahead=new int[2];
        // int[] curr=new int[2];

        int aheadBuy,aheadNotBuy,currBuy,currNotBuy;
        aheadBuy=aheadNotBuy=0;

        // Arrays.fill(ahead,0);
        // Arrays.fill(curr,0);

        // for(int[] row:dp)
        // {
        //     Arrays.fill(row,0);
        // }

        // ahead[0]=0;
        // ahead[1]=0;

        for(int i=days-1;i>=0;i--)
        {
            //Buy
            currBuy=Math.max(-prices[i]+aheadNotBuy,0+aheadBuy);

            //Sell
            currNotBuy=Math.max(prices[i]-fee+aheadBuy,0+aheadNotBuy);

            aheadBuy=currBuy;
            aheadNotBuy=currNotBuy;
        }

        return aheadBuy;
        
    }
}