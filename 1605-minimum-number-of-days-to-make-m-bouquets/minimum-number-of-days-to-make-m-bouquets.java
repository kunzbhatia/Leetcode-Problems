class Solution {
    public int minDays(int[] bloomDay, int m, int k) 
    {
        int low = minEle(bloomDay);
        int high = maxEle(bloomDay);
        int ans = high;
        int n = bloomDay.length;

        long val = (long) m * k;
        if (val > n) return -1; // not possible case

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (possible(bloomDay, mid, m, k))
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean possible(int[] bloomDay, int day, int m, int k) 
    {
        int count = 0;
        int noOfBouquets = 0;

        for (int i = 0; i < bloomDay.length; i++)
        {
            if (bloomDay[i] <= day)
            {
                count++;
                if (count == k)
                {
                    noOfBouquets++;
                    count = 0;
                }
            }
            else
            {
                count = 0;
            }
        }

        return noOfBouquets >= m;
    }

    public int maxEle(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }

    public int minEle(int[] arr)
    {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < min)
            {
                min = arr[i];
            }
        }
        return min;
    }
}
