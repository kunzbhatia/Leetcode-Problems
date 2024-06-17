class Solution 
{
    public int largestRectangle(int[] height) 
    {
        Stack<Integer> st=new Stack<>();
        int maxA=0;
        int n=height.length;
        for(int i=0;i<=n;i++)
        {
            while(!st.empty() && (i==n || height[st.peek()]>=height[i]))
            {
                int heigth=height[st.peek()];
                st.pop();

                int width;
                if(st.empty()) width=i;
                else width=i-st.peek()-1;

                maxA=Math.max(maxA,width*heigth);
            }
            st.push(i);
        }
        return maxA;
    
    }

    public int maximalRectangle(char[][] matrix) 
    {
        int[] height=new int[matrix[0].length];
        Arrays.fill(height,0);
        int maxArea=Integer.MIN_VALUE;
        for(char[] row :matrix)
        {
            for(int i=0;i<matrix[0].length;i++)
            {
                if(row[i]=='1') height[i]++;
                else height[i]=0;

                System.out.print(height[i]);
            }
            System.out.println();
        
            int sum=largestRectangle(height);
            maxArea=Math.max(maxArea,sum);
        }

        return maxArea;
        
    }
}