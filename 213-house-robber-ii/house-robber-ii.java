class Solution 
{
    public int helperRob(int nums[],int n,int[] dp)
    {
        if(n==0) return nums[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];

        int pick= nums[n]+ helperRob(nums,n-2,dp);
        int notpick= 0+ helperRob(nums,n-1,dp);

        return dp[n]=Math.max(pick,notpick);
    }



    public int rob(int[] nums) 
    {
         int n = nums.length;

        // Handle edge cases
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Initialize two subarrays
        int[] nums1 = Arrays.copyOfRange(nums, 0, n - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, n);

        // Initialize dp arrays for both subproblems
        int[] dp1 = new int[n - 1];
        int[] dp2 = new int[n - 1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        // Solve both subproblems and return the maximum of the two
        return Math.max(helperRob(nums1, n - 2, dp1), helperRob(nums2, n - 2, dp2));
}
}