class Solution 
{
    public boolean check(int[] nums) 
    {
        int change=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>nums[(i+1)%n])
            change+=1;
        }
        return change>1 ? false:true;
}
}
