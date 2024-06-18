import java.util.*;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        
        // Sort jobs by difficulty, and by profit in case of tie
        Arrays.sort(jobs, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        
        // Sort worker array
        Arrays.sort(worker);
        
        // Prepare for binary search
        int[] maxProfit = new int[n];
        maxProfit[0] = jobs[0][1];
        
        for (int i = 1; i < n; i++) 
        {
            maxProfit[i] = Math.max(maxProfit[i - 1], jobs[i][1]);
        }
        
        int sum = 0;
        for (int w : worker) 
        {
            int ind = Arrays.binarySearch(jobs, new int[] { w, Integer.MAX_VALUE }, (a, b) -> a[0] - b[0]); //for 2d binary search
            if (ind < 0) 
            {
                ind = -ind - 2;
            }
            if (ind >= 0) 
            {
                sum += maxProfit[ind];
            }
        }
        
        return sum;
    }
}
