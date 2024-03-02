class Solution {
    public static int majorityElement(int []nums) 
    {
        //MOORE"S VOTING ALGORITHM
        int count=0;
        int ele=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(count==0)
            {
                count=1;
                ele=nums[i];
            }
            else if(ele==nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        // int count2=0;

        // for(int i=0;i<n;i++)
        // {
        //     if(v[i]==ele)
        //     {
        //         count2++;
        //     }
        // }

        // if(count2>(n/2)) return ele;
        // else return -1;
        return ele;
    }
}