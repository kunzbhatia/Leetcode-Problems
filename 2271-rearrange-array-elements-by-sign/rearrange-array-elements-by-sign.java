class Solution {
    public int[] rearrangeArray(int[] nums) 
    {
        int n=nums.length,k=0,l=0;
        int[] pos=new int[n/2];
        int [] neg=new int[n/2];
        int[] ans=new int[n];
        for(int i=0;i<n;i++)
        {
            if(nums[i]<0)
            {
            neg[k]=nums[i];
            k++;
            }
            else
            {
            pos[l]=nums[i];
            l++;
            }
        }

         for(int i=0;i<n/2;i++)
        {
            ans[2*i]=pos[i];
            ans[2*i+1]=neg[i];
        }

        return ans;


    }
}