class Solution {
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
  
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        // Handle cases where k is greater than or equal to n
        k = k % n;

        // Reverse first n-k elements
        reverse(nums, 0, n - k - 1);
        // Reverse last k elements
        reverse(nums, n - k, n - 1);
        // Reverse whole array
        reverse(nums, 0, n - 1);
    }
}
