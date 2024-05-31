class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        // Step 1: Find the XOR of the two unique numbers
        for (int num : nums) 
        {
            xor ^= num;
        }
        System.out.println(xor);
        System.out.println(-xor);
        
        // Step 2: Find the rightmost set bit in xor
        int diff = xor & (-xor);
        
        System.out.println(diff);

        // Step 3: Divide the numbers into two groups and XOR them separately
        int num1 = 0, num2 = 0;
        for (int num : nums) 
        {
            if ((num & diff) == 0) 
            {
                num1 ^= num;
            } 
            else 
            {
                num2 ^= num;
            }
        }
        
        // Return the two unique numbers
        return new int[]{num1, num2};
    }
}