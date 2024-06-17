class Solution 
{
    public int minCostRecur(int i,int j, List<Integer> newcuts,int[][] dp)
    {
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int mini=1000000000;

        for(int k=i;k<=j;k++)
        {
            int cost=newcuts.get(j+1)-newcuts.get(i-1) + minCostRecur(i,k-1,newcuts,dp)+ minCostRecur(k+1,j,newcuts,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }

    public int minCost(int n, int[] cuts)
    {
        ArrayList<Integer> newcuts = new ArrayList<>();
        for (int cut : cuts) 
        {
            newcuts.add(cut);
        }
        newcuts.add(0);
        newcuts.add(n);

        // Sort the cuts
        Collections.sort(newcuts);
        int[][] dp = new int[cuts.length + 2][cuts.length + 2];

        for (int[] row : dp) 
        {
            Arrays.fill(row, -1);
        }

        return minCostRecur(1,cuts.length,newcuts,dp);

    }
}