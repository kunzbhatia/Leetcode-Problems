class Solution 
{
    public List<Integer> largestDivisibleSubset(int[] nums) 
    {
        int [] dp=new int[nums.length];
        int [] hash=new int[nums.length];
        Arrays.fill(dp,1);

        Arrays.sort(nums);
        
        int maxi=0,lastindex=0;

        for(int i=0;i<nums.length;i++)
        {
            hash[i]=i;
            for(int prev=0;prev<i;prev++)
            {
                if(nums[i]%nums[prev]==0 && dp[i]<1+dp[prev])
                {
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi)
            {
                maxi=dp[i];
                lastindex=i;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(nums[lastindex]);
        while(hash[lastindex]!=lastindex)
        {
            lastindex=hash[lastindex];
            ans.add(nums[lastindex]);
        }

        Collections.sort(ans);
        return ans;
        
    }
}
