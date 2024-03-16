class Solution 
{
    //TC O(n), SC O(n)
    public int findMaxLength(int[] nums) 
    {
        int maxLen=0;
        int n=nums.length;
        int prefixSum=0;
        Map<Integer,Integer> mpp=new HashMap<>();
        mpp.put(0,-1); //for initial marking that prefix sum is zero, prefix-->index

        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            {
                prefixSum--;
            }
            else
            prefixSum++;

            if(mpp.containsKey(prefixSum))
            {
                int currentLen=i-mpp.get(prefixSum); //3-(-1)= 4  or 
                maxLen=Math.max(maxLen,currentLen);  
            }
            else
            mpp.put(prefixSum,i); //every sum first instance storing
        }
        return maxLen;
    }
}