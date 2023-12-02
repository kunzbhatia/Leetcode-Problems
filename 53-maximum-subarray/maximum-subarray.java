public class Solution 
{
    public static int maxSubArray(int[] nums) {
        int currentMax = 0;           // Current maximum subarray sum
        int maxTillNow = Integer.MIN_VALUE;  // Maximum subarray sum found so far
        
        for (int num : nums) {
            currentMax = Math.max(num, currentMax + num); // Update the current maximum subarray sum
            maxTillNow = Math.max(maxTillNow, currentMax); // Update the maximum subarray sum found so far
        }
        
        return maxTillNow;  // Return the maximum subarray sum
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = maxSubArray(arr);
        System.out.println(ans);
    }
}
