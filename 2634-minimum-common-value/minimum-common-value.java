class Solution 
{
    public int getCommon(int[] nums1, int[] nums2) 
    {
        int i=0,j=0;
        int min=Integer.MAX_VALUE;
        int n1=nums1.length,n2=nums2.length;
       while(i < n1 && j < n2)
        {
            if(nums1[i]>nums2[j])
            {
                j++;
            }
            else if(nums1[i]<nums2[j])
            {
                i++;
            }

            else if(nums1[i]==nums2[j] && nums1[i]<min)
            {
                min=nums1[i];
                i++;
                j++;
            }
            else
            {
                i++;
                j++;
            }

        }
        if(min!=Integer.MAX_VALUE)
        {
        return min;
        }
        return -1;
    }
}