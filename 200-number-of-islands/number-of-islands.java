class Solution 
{
    public void dfs(int row, int col, int[][] vis, char[][] grid) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        // Define the directions for up, down, left, and right
        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            // Check if the new position is within bounds and is unvisited land
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0 && grid[newRow][newCol] == '1') {
                dfs(newRow, newCol, vis, grid);
            }
        }
    }


    public int numIslands(char[][] grid) 
    {
        int n=grid.length;
        int m=grid[0].length;

        int cnt=0;

        int [][] vis=new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    cnt++;
                    dfs(i,j,vis,grid);
                }
            }
        }

        return cnt;
        
    }
}