class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int low=1;
        int high=maxEle(piles);
        int ans=Integer.MAX_VALUE;;

        while(low<=high)
        {
            int mid = (low + high) / 2;

            int totalhrs=hours(piles,mid);

            if(totalhrs<=h)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
         
        }
        return low;
    }
    
    public int hours(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double) arr[i] / n); // Use double division to ensure correct ceiling calculation
        }
        return sum;
    }

    public int maxEle(int [] arr)
    {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
    
        return max;
        
    }

        
}