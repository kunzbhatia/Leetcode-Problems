class Solution {
    public boolean rotateString(String s, String goal) 
    {
        if(goal.length()!=s.length())
        return false;

        String ans=s+s;
        if(ans.contains(goal))
        return true;

        return false;
    }
}