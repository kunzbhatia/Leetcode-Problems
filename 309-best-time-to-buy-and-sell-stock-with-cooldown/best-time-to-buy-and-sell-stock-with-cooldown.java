class Solution {
     public int maxProfit(int[] prices) 
    {
        int days=prices.length;
        // int[][]dp=new int[days+2][2];
        int[] after2=new int[2];
        int[] after1=new int[2];
        int[] curr=new int[2];

        Arrays.fill(after2,0);
        Arrays.fill(after1,0);
        Arrays.fill(curr,0);

        // for(int[] row:dp)
        // {
        //     Arrays.fill(row,0);
        // }

        // dp[days][0]=0;
        // dp[days][1]=0;

        for(int i=days-1;i>=0;i--)
        {
  
        curr[1]=Math.max(-prices[i]+after1[0],0 + after1[1]);
        
        curr[0]=Math.max(prices[i]+after2[1],0 + after1[0]);  

        //after2=after1;
        System.arraycopy(after1,0,after2,0,2);
        //after1=curr;
        System.arraycopy(curr,0,after1,0,2);

        

        }

        return curr[1];
        
    }
}