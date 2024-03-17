
class Solution {
    //TC O(n*m)  & SC O(n*m) (to store)
    public List<Integer> spiralOrder(int[][] matrix)  {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;
        List<Integer> list=new ArrayList<>();

        while (left <= right && top <= bottom) {
            // RIGHT
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);  
            }
            top++;

            // BOTTOM
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
             
            }
            right--;

            // LEFT
            if (top <= bottom) { // as top and right both is changed
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]); 
                  
                }
                bottom--;
            }

            // TOP
            if (left <= right) {// as top and right both is changed
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]); 

                }
                left++;
            }
        }
        return list;
    }
}
