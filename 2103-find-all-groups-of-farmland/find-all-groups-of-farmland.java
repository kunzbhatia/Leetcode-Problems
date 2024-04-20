class Solution {
    int endRow = 0, endCol = 0;         //to store the end of present farm, 
                                        // initially assumed that there are no farms hence ends at 0, 0
    int row, col;
    public int[][] findFarmland(int[][] land) {
        row = land.length;
        col = land[0].length;
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(land[i][j] == 1){
                    // we have found the start of a farm land
                    // r1 = i, c1 = j
                    //we now need to find the ends, i.e, endRow and endCol for the farm
                    //for this we can excecute a dfs to adjust out endRow and endCol 
                    
                    dfs(land, i, j);            //this should populate our endRow and endCol
                    //after excecuting the dfs we must have r1 = i, c1 = j, r2 = endRow and c2 = endCol
                    list.add(new int[]{i, j, endRow, endCol});
                    
                    //we need to reinitialize endRow and endCol for any nextPossible entry
                    endRow = 0;
                    endCol = 0;
                }
            }
        }
        
        // we have a list of entries, we just need to add into an array and return
        // Integer[][] arr = new Integer[list.size()];       // we use Integer as toArray func returns an Object which needs to be type casted
        // arr = list.toArray();
        // return arr;
        // 
        int arr[][] = new int[list.size()][4];
        for(int i = 0; i<arr.length; i++)arr[i] = list.get(i);
        return arr;
        
        //we can also use int[] arr = list.stream().mapToInt(i -> i).toArray(); to convert 
    }
    
    public void dfs(int[][] land, int i, int j){
        //base case - when we go beyong the boundaries OR if we reach a forest area
        if(i<0 || j<0 || i>=row || j>=col || land[i][j] == 0)return; 
        
        land[i][j] = 0;
        //marking the land as visited to avoid stackoverflow
        dfs(land, i+1, j);      
        //dfs(land, i-1, j);   --- I realised that if we only move right and bottom the runtime increases significantly, although I didnt understand why. Pls let me know if you understand
        dfs(land, i, j+1);
        //dfs(land, i, j-1);
        
        endRow = Math.max(endRow, i);
        endCol = Math.max(endCol, j);
    }
}