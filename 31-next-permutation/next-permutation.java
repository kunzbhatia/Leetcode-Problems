class Solution {
    public void nextPermutation(int[] nums) 
    {
        int ind=-1;
        int n=nums.length;

        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                ind=i;
                break;
            }
        }

        if(ind==-1)
        {
            reverse(nums,0);
            return;
        }
        for(int i=n-1;i>=ind;i--)
        {
            if(nums[i]>nums[ind])
            {
                swap(nums,i,ind);
                break;
            }
        }

        reverse(nums,ind+1);
    }
    public static void reverse(int[] nums, int start)
    {
        int i=start;
        int j=nums.length-1;
        while(i<j)
        {
            swap(nums,i,j);
            i++;
            j--;
        }

    }
    public static void swap(int[] nums, int first,int second)
    {
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;  
    }
}