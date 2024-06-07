class Solution 
{
    public int helperRob(int nums[],int n,int[] dp)
    {
        if(n==0) return nums[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];

        int pick=nums[n]+ helperRob(nums,n-2,dp);
        int notpick=0+ helperRob(nums,n-1,dp);

        return dp[n]=Math.max(pick,notpick);
    }



    public int rob(int[] nums) 
    {
        int n=nums.length-1;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);

        return helperRob(nums,n,dp);
        
    }
}