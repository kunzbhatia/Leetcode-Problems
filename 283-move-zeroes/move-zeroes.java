class Solution {
    public void moveZeroes(int[] nums) 
    {
        int j = -1;
        //place the pointer j:
        for (int i = 0; i < nums.length; i++)   //O(x)
        {
            if (nums[i] == 0) //first zero
            {
                j = i;
                break;
            }
        }

        //no non-zero elements:
        if (j == -1) return;

        //Move the pointers i and j
        //and swap accordingly:

        for (int i = j + 1; i < nums.length; i++)   //O(N-x)
        {
            if (nums[i] != 0) 
            {
                //swap a[i] & a[j]:
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        } 
    }
}