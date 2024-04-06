class Solution {
    public String minRemoveToMakeValid(String s) 
    {
        Stack<Integer> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isAlphabetic(c)) //is Alphabetic 
            {
                continue;
            }
            else if (c=='(')
            {
                st.push(i); //at i index their exixt a singular bracket
            }
            else
            {
                if(!st.isEmpty() && s.charAt(st.peek())=='(') //there exist a pair for (
                    {
                        st.pop();
                    }
                else
                {
                    st.push(i); //if no pair then push that index as well
                }
            }

        }
        HashSet<Integer> set=new HashSet<>(st); //building set of the stack
        for(int i=0;i<s.length();i++)
        {
            if(!set.contains(i))
            {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
        
    }
}