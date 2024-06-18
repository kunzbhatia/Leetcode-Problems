class Solution {
    public String longestPalindrome(String s) 
    {
        String lps="";

        int n=s.length();

        for(int i=0;i<n;i++)
        {
            //odd
            String odd=expandpalidrome(s,i,i);
            String even=expandpalidrome(s,i,i+1);

            if(lps.length()<odd.length()) lps=odd;

            if(lps.length()<even.length()) lps=even;
        }

        return lps;
        
    }

    public String expandpalidrome(String s,int l, int r) 
    {

        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
        {
            l--;
            r++;
        }
        
        return s.substring(l+1,r);
    }
}