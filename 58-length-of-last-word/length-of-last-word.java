class Solution {
    public int lengthOfLastWord(String s) 
    {
        int start=0;
        String sub=s.trim();
        System.out.println(sub);
        for(int i=sub.length()-1;i>0;i--)
        {
            if(sub.charAt(i)!=' ' && sub.charAt(i-1)==' ')
            {
                start=i;
                System.out.println(start);
                break;
            }
        }
        int ans=sub.length()-start;
        return ans;
        
    }
}