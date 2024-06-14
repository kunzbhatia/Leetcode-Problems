
class Solution {

    public int minuniquePaths(int m, int n,int[][] dp,int[][] grid) 
    {
        if(m==0 && n==0) return grid[0][0];
        if(m<0 || n<0) return Integer.MAX_VALUE;

        if(dp[m][n]!=-1) return dp[m][n];

        int up=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;

        if(m>0) up= grid[m][n]+ minuniquePaths(m-1,n,dp,grid);
        if(n>0) left= grid[m][n]+ minuniquePaths(m,n-1,dp,grid);

        return dp[m][n]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) 
    {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m+1][n+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }

        return minuniquePaths(m-1,n-1,dp,grid);
        
    }
}