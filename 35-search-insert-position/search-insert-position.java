class Solution {
    public int searchInsert(int[] nums, int target) 
    {
        int ind=Arrays.binarySearch(nums,target);
        if(ind<0)
        {
            ind=-ind-1;
        }
       
       return ind;
        // int low = 0;
        // int high = nums.length - 1;

        // while (low <= high) 
        // {
        //     int mid = low + (high - low) / 2;

        //     if (nums[mid] == target) 
        //     {
        //         return mid;
        //     } 
            
        //     else if (nums[mid] < target) {
        
        //         low = mid + 1;
        //     } else {
        
        //         high = mid - 1;
        //     }
        // }

        // return high+1;
    }
}