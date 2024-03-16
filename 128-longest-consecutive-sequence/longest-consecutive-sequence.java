class Solution {
    public int longestConsecutive(int[] nums) 
    {
        int n=nums.length;
        if(n==0) return 0;
        int longest=1,count=0,x=Integer.MIN_VALUE;

        Set<Integer> set=new HashSet<>();

        for(int i=0;i<n;i++)
        {
            set.add(nums[i]);
        }

        for(int it : set)
        {
            if(!set.contains(it-1))
            {
                count=1;
                x=it;
            }
            while(set.contains(x+1))
            {
                count++;
                x++;
            }
            longest=Math.max(longest,count);
        }
        return longest;
    }
}