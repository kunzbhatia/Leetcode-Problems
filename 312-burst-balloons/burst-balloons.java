class Solution 
{
    public int maxCoinsRecur(int i, int j, List<Integer> nums,int[][] dp) 
    {
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int maxi=-1000000000;
        for(int k=i;k<=j;k++)
        {
            int cost=nums.get(i-1)*nums.get(k)*nums.get(j+1)+maxCoinsRecur(i,k-1,nums,dp)+ maxCoinsRecur(k+1,j,nums,dp);
            maxi=Math.max(maxi,cost);
        }
        return dp[i][j]=maxi;
    }
    public int maxCoins(int[] nums) 
    {
        List<Integer> newnums=new ArrayList<>();
        newnums.add(1);
        for(int n:nums)
        {
            newnums.add(n);
        }
        newnums.add(1);

        int n=nums.length;
        int[][] dp=new int[n+1][n+1];
        for(int []row:dp)
        {
            Arrays.fill(row,-1);
        }

        return maxCoinsRecur(1,n,newnums,dp);
    }
}