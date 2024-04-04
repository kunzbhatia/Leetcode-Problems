class Solution {
    public String removeOuterParentheses(String s) 
    {
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                if(st.size()>0) sb.append(s.charAt(i));
                st.push(s.charAt(i));
            }
            else
            {
                st.pop();
                if(st.size()>0) sb.append(s.charAt(i));
            }
        }
        return sb.toString();
        
    }
}