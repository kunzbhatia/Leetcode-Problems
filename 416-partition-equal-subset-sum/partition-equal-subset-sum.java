class Solution 
{
    public boolean canPartitionRecur(int i,int target, int[] nums,int[][]dp) 
    {
        if(target==0) return true;
        if(i==0) return nums[0]==target;

        if(dp[i][target]!=-1) return dp[i][target]==1? true:false;

        boolean nottake=canPartitionRecur(i-1,target,nums,dp);
        boolean take=false;

        if(nums[i]<=target) take=canPartitionRecur(i-1,target-nums[i],nums,dp);

        dp[i][target]= (take || nottake) ? 1 : 0;

        return dp[i][target]==1 ;
        
    }
    public boolean canPartition(int[] nums) 
    {
        int n=nums.length;
        int sum=0;
        for(int i: nums)
        {
            sum+=i;
        }

        if(sum%2==1) return false;

        int target=sum/2;

        int[][] dp=new int[n][target+1];

        for(int[] row: dp)
        {
            Arrays.fill(row,-1);
        }

        return canPartitionRecur(n-1,target,nums,dp);
 
    }
}