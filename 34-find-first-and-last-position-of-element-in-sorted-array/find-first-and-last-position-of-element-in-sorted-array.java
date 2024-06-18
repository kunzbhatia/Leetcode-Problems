class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ind = Arrays.binarySearch(nums, target);
        
        if (ind < 0) {
            return new int[]{-1, -1};
        }
        
        int first = ind;
        int last = ind;
        
        // Find the first occurrence
        while (first > 0 && nums[first - 1] == target) {
            first--;
        }
        
        // Find the last occurrence
        while (last < nums.length - 1 && nums[last + 1] == target) {
            last++;
        }
        
        return new int[]{first, last};
    }
}
