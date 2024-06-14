class Solution {

    public int minuniquePaths(int m, int n,int[][] dp,List<List<Integer>> triangle) 
    {
        if(m==triangle.size()-1) return triangle.get(m).get(n);
        if(m<0 || n<0) return Integer.MAX_VALUE;

        if(dp[m][n]!=-1) return dp[m][n];

        int up=Integer.MAX_VALUE;
        int left=Integer.MAX_VALUE;

        up= triangle.get(m).get(n)+ minuniquePaths(m+1,n,dp,triangle);
        left= triangle.get(m).get(n)+ minuniquePaths(m+1,n+1,dp,triangle);

        return dp[m][n]=Math.min(up,left);
    }

    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int m=triangle.size();
        int n=triangle.get(m-1).size();
        int dp[][]=new int[m+1][n+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }

        return minuniquePaths(0,0,dp,triangle);
    }
}