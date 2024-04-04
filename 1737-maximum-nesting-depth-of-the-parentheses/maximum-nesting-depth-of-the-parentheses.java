class Solution {
    public int maxDepth(String s) 
    {
        int depth=0,open=0;
        // for(char c: s.toCharArray())
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            open++;

            else if(s.charAt(i)==')')
            open--;
            
            depth=Math.max(depth,open);
        }
        return depth;
    }
}