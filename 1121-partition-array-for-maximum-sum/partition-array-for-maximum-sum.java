class Solution
{
    public int maxSumAfterPartitioningRecur(int i,int[] arr, int k,int[] dp) 
    {
        if(i==arr.length) return 0;

        if(dp[i]!=-1) return dp[i];

        int len=0,maxi=Integer.MIN_VALUE,maxans=Integer.MIN_VALUE,sum=0;

        for(int j=i;j<Math.min(i+k,arr.length);j++)
        {
            len++;
            maxi=Math.max(maxi,arr[j]);
            sum=(len*maxi)+maxSumAfterPartitioningRecur(j+1,arr,k,dp);
            maxans=Math.max(maxans,sum);
        }

        return dp[i]=maxans;
        
    }

    public int maxSumAfterPartitioning(int[] arr, int k) 
    {
        int[]dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return maxSumAfterPartitioningRecur(0,arr,k,dp);
    }
}