class Solution {
    public String reverseWords(String s) 
    {
        StringBuilder sb=new StringBuilder();
        String[] words=s.trim().split(" +");
        for(int i=words.length-1;i>0;i--)
        {
            sb.append(words[i]+" ");
        }
        sb.append(words[0]);
        return sb.toString();
    }
}