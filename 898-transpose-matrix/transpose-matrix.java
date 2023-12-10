//lancertech6
class Solution {
    public int[][] transpose(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int arr[][]=new int[col][row];
        for(int i=0;i<col;i++)
        {
            for(int j=0;j<row;j++)
            {
            arr[i][j]=matrix[j][i];
            }
        }
        return arr;
    }
}
// Time Complexity: O(m * n) where m and n are the number of rows and columns in the matrix.
// Space Complexity: O(m * n) for the transposed matrix.

//Follow up for square matrix transpose "in place"
// class Solution {
//     public int[][] transpose(int[][] matrix) {
//         int n = matrix.length;
        
//         for (int i=0; i<n; i++) {
//             for (int j=i+1; j<n; j++) {
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[j][i];
//                 matrix[j][i] = temp;
//             }
//         }
        
//         return matrix;
//     }
// }