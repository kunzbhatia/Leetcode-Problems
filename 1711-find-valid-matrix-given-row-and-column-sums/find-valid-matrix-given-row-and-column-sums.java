class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) 
    {
        int ans[][]=new int[rowSum.length][colSum.length];
        int i=0,j=0;
        while(i<rowSum.length && j<colSum.length)
        {
            int min=Math.min(rowSum[i],colSum[j]);
            ans[i][j]=min;
            rowSum[i]-=min;
            colSum[j]-=min;
            if(rowSum[i]==0) i++;
            if(colSum[j]==0) j++;
        }
    
        return ans;

    }
}