class Solution {
    public void rotate(int[][] matrix) 
    {
        // Write your code here.
        int n=matrix.length;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                swap(matrix,i,j);
            }
        }
        for(int i=0;i<n;i++)
        {
            reverse(matrix,i);
        }
    }

    public static void swap(int a[][],int i, int j)
    {
        int temp=a[i][j];
        a[i][j]=a[j][i];
        a[j][i]=temp;
    }

    public static void reverse(int[][] a,int row)
    {
        int start=0;
        int end=a.length-1;
        while(start<end)
        {
             int temp=a[row][start];
             a[row][start]=a[row][end];
             a[row][end]=temp;
            start++;
            end--;
        }
    }
}
