// class Solution {
//     public int findTargetSumWaysrecur(int n, int[] nums, int target, int[][] dp) {
//         // Early termination if target is out of the valid range
//         if (target < -1000 || target > 1000) {
//             return 0;
//         }
        
//         // Base case when we have only one element to consider
//         if (n == 0) {
//             if (nums[0] == target || nums[0] == -target) {
//                 return 1;
//             } else {
//                 return 0;
//             }
//         }
        
//         // Memoization check
//         if (dp[n][target + 1000] != -1) {
//             return dp[n][target + 1000];
//         }
        
//         // Recursive calls to compute number of ways
//         int pos = findTargetSumWaysrecur(n - 1, nums, target - nums[n], dp);
//         int neg = findTargetSumWaysrecur(n - 1, nums, target + nums[n], dp);
        
//         // Store the result in dp table
//         dp[n][target + 1000] = pos + neg;
        
//         return dp[n][target + 1000];
//     }

//     public int findTargetSumWays(int[] nums, int target) {
//         int n = nums.length;
//         int[][] dp = new int[n][2001]; // dp array covers from -1000 to 1000
        
//         // Initialize dp array with -1 to signify uncomputed states
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         // Start recursive function from the last element of nums
//         return findTargetSumWaysrecur(n - 1, nums, target, dp);
//     }
// }


class Solution {
    
     public static int perfectSum(int arr[], int n, int sum) 
     {
        int mod = 1000000007;
        int[][] dp = new int[n+1][sum + 1];

        // There's always one way to get sum 0: pick no elements
        for (int i = 0; i <=n; i++) {
            dp[i][0] = 1;
        }

        // Initialize dp[0][arr[0]] if arr[0] <= sum
        // if (arr[0] <= sum) {
        //     dp[0][arr[0]] = 1;
        // }

        // Fill dp array
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <= sum; j++) {
                // Not taking the element
                dp[i][j] = dp[i - 1][j];

                // Taking the element if it's not greater than the remaining sum
                if (arr[i-1] <= j) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - arr[i-1]]) % mod;
                }
            }
        }

        return dp[n][sum];
    }
    
    public static int countPartitions(int n, int d, int[] arr) {
        int sum = Arrays.stream(arr).sum();
        
        // Calculate the target difference based on d
        int target = (sum + d) / 2;
        
        // If the difference is odd or negative, it's not possible to partition as required
        if ((sum + d) % 2 != 0 || (sum+d)<0 )  
        {
            return 0;
        }
        
        // Compute the number of ways to achieve the target sum using perfectSum function
        return perfectSum(arr, n, target);
    }

    public int findTargetSumWays(int[] nums, int target) 
    {
        int n=nums.length;
        return countPartitions(n,target,nums);
    }
}

        
