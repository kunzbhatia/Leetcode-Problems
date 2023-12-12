class Solution {
    public int maxProduct(int[] nums) 
    {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) 
        {
            if (num >= max1) 
            {
                max2 = max1;
                max1 = num;
            } 
            else if (num > max2) 
            {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}



// Time Complexity: O(N), where N is the length of the array. We iterate through the array once.
// Space Complexity: O(1), as we use a constant amount of extra space.
