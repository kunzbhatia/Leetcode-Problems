class Solution {
    public int subarraySum(int[] nums, int k) 
    {
        Map<Integer,Integer> mpp=new HashMap<>();
        int preSum=0,count=0;
        mpp.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            preSum+=nums[i];
            int remove=preSum-k;
            count+=mpp.getOrDefault(remove,0);
            mpp.put(preSum,mpp.getOrDefault(preSum,0)+1);
        }
        return count;
        
    }
}