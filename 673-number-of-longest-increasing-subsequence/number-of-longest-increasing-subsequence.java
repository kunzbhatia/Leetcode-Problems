class Solution {
    public int findNumberOfLIS(int[] nums) 
    {
        int n=nums.length;

        // Initialize arrays to store LIS and LDS
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);

        int maxi=0;
        int totalcount=0;

        // Compute LIS (Longest Increasing Subsequence)
        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < i; j++) 
            {
                if (nums[i] > nums[j]&& dp[j]+1 >dp[i]) 
                {
                    dp[i] = dp[j] + 1;
                    count[i]=count[j];
                }
                else if(nums[i] > nums[j]&& dp[j]+1==dp[i])
                {
                    count[i]+=count[j];
                }
            }
            maxi=Math.max(maxi,dp[i]);

        }
        
        for(int i=0;i<n;i++)
        {
            if(dp[i]==maxi)
            {
                totalcount+=count[i];
            }
        }

        return totalcount;
        
    }
}