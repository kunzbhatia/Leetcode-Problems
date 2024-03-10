class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) 
    {
        Arrays.sort(capacity);
        int sum=0;
        int ans=0;
        for(int nums:apple)
        {
            sum=sum+nums;
        }
        int i=capacity.length-1;
        while(i>=0)
        {
            sum=sum-capacity[i];
            ans++;
            if(sum<=0)
            {
                break;
            }
            i--;
        }
        return ans;
        
    }
}