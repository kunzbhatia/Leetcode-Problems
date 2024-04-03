class Solution {
    public boolean backtrack(char[][] board,String word,boolean visited[][],int i, int j, int index)
    {
        if(index==word.length()) //true edge condition
        return true;

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] || board[i][j]!=word.charAt(index) )
        return false;

        visited[i][j]=true;

        if(backtrack(board,word,visited,i+1,j,index+1)
        ||backtrack(board,word,visited,i-1,j,index+1)||backtrack(board,word,visited,i,j+1,index+1)
        || backtrack(board,word,visited,i,j-1,index+1) )  //checking in all directions for next letter recursively
        {
            return true;
        }

        visited[i][j]=false;
        return false;
    }

    public boolean exist(char[][] board, String word) 
    {
        int m=board.length;
        int n=board[0].length; //size of the board

        boolean visited[][]=new boolean[m][n]; //visted matrix for the word
        boolean result=false; //initial result

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    result=backtrack(board,word,visited,i,j,0);
                    if(result) return true;
                }
            }
        }
        return false;
    }
}