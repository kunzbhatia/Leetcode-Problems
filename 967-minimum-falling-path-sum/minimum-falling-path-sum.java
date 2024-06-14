class Solution 
{
    public int minPaths(int m, int n,int[][] dp,int[][] grid) 
    {

        if(n<0 || n>=grid[0].length) return 10000000;
        if(m==0) return grid[0][n];
        
        if(dp[m][n]!=-1) return dp[m][n];

        int up= grid[m][n]+ minPaths(m-1,n,dp,grid);
        int leftd= grid[m][n]+ minPaths(m-1,n-1,dp,grid);
        int rightd= grid[m][n]+ minPaths(m-1,n+1,dp,grid);

        return dp[m][n]=Math.min(up,Math.min(leftd,rightd));
    }

    public int minFallingPathSum(int[][] matrix) 
    {
        int m=matrix.length;
        int n=matrix[0].length;

        int [][] dp=new int[m][n];

        for(int [] row:dp)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int j=0;j<n;j++) dp[0][j]=matrix[0][j];

        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up = matrix[i][j] + dp[i - 1][j];
                int leftd = (j > 0) ? matrix[i][j] + dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int rightd = (j < n - 1) ? matrix[i][j] + dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j]=Math.min(up,Math.min(leftd,rightd));
            }
        }



        int mini=dp[m-1][0];

        for(int j=1;j<n;j++)
        {
        mini=Math.min(mini,dp[m-1][j]);
        }

        return mini;
    }
}