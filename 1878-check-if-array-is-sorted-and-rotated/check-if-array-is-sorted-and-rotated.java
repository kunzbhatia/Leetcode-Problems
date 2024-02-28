class Solution {
    public boolean check(int[] nums) 
    {
        int backrotate=0;
        int[] newnum=new int[nums.length];
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                backrotate=i+1;
                break;
            }
        }

        for( int i=0;i<nums.length;i++)
        {
            newnum[i]=nums[(i+backrotate)%newnum.length];
        }

        for(int i=0;i<newnum.length-1;i++)
        {
            if(newnum[i]>newnum[i+1])
            {
                return false;
            }  
        }
        return true;
}
}