class Solution 
{

    public int recuruniquePaths(int m, int n,int[][] dp,int[][] obstacleGrid) 
    {
        if(m>=0 && n>=0 && obstacleGrid[m][n]==1) return 0;
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;

        if(dp[m][n]!=-1) return dp[m][n];

        int up= recuruniquePaths(m-1,n,dp,obstacleGrid);
        int left= recuruniquePaths(m,n-1,dp,obstacleGrid);

        return dp[m][n]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) 
    {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m+1][n+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }

        return recuruniquePaths(m-1,n-1,dp,obstacleGrid);
        
    }
}