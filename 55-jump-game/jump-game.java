class Solution 
{
    // [3,0,1,1,4]
    //initialize int jumps=0
    //transverse the array from start to finish
        //if(nums[i]>jumps) jumps=nums[i]
        //else jumps=-1;
    public boolean canJump(int[] nums) 
    {
        int n=nums.length;
        int jumps=0;
        for(int i=0;i<n;i++)
        {
            if (jumps<0)
            {
                return false;
            }
            if(i==0)
            {
                jumps=nums[i];
            }
            else if(nums[i]>=jumps && jumps!=0) 
            {
            jumps=nums[i];
            }
            else
            {
            jumps-=1;
            if(jumps<0)
            {
                return false;
            }
            }
        }

    return true;
    }

}