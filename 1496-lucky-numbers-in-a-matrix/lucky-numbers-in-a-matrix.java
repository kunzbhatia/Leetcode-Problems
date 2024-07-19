class Solution 
{

    public boolean lucky(int a,int[][] matrix, int r,int c)
    {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            if(matrix[i][c]>a) return false;
        }
        for(int j=0;j<n;j++)
        {
            if(matrix[r][j]<a) return false;
        }

        return true;

    }
    public List<Integer> luckyNumbers (int[][] matrix) 
    {
        int m=matrix.length;
        int n=matrix[0].length;
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(lucky(matrix[i][j],matrix,i,j))
                {
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    
        

        
    }
}