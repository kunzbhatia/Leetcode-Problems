class Solution 
{
    // public boolean targetsumRecur(int i,int c,int limit,int[]arr,int[][][]dp) 
    // {
    //     if(limit==0)
    //     {
    //     if(c==0) return true;
    //     }
    //     if(i==0)
    //     {
    //         if(limit==1)
    //         {
    //         return arr[0]==c;
    //         }
    //         return false;
    //     }
    

    //     boolean nottake= targetsumRecur(i-1,c,limit,arr,dp);
    //     boolean take=false;
    //     if(arr[i]<=c) take=targetsumRecur(i-1,c-arr[i],limit-1,arr,dp);

    //     return take || nottake;


    // }

    //TWO POINTERS ARRAY APPROACH IS BETTER
    //Two sum , two things--> Two pointers
     public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            long leftSquare = (long) left * left;
            long rightSquare = (long) right * right;
            long sumOfSquares = leftSquare + rightSquare;

            if (sumOfSquares == c) {
                return true;
            } else if (sumOfSquares < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}