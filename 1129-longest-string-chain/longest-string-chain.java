class Solution 
{
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();

    public int longestStrChain(String[] words) 
    {
        int [] dp=new int[words.length];

        List<String> arr = Arrays.asList(words);

        arr.sort(comp); //sorting based on comparator

        Arrays.fill(dp,1);
        
        int maxi=0;

        for(int i=0;i<words.length;i++)
        {
            for(int prev=0;prev<i;prev++)
            {
                if(Compare(arr.get(i),arr.get(prev)) && dp[i]<1+dp[prev])
                {
                    dp[i]=1+dp[prev];
                }
            }
            if(dp[i]>maxi)
            {
                maxi=dp[i];
            }
        }
        return maxi;
    }


    public static boolean Compare(String s1,String s2)
    {
        if(s1.length()!=s2.length()+1) return false;

        int first=0; //larger number by one
        int second=0;

        char [] str1=s1.toCharArray();
        char [] str2=s2.toCharArray();

        while(first<s1.length())
        {
            if(second<s2.length() && str1[first]==str2[second])
            {
                first++;
                second++;
            }
            else
            {
                first++;
            }
        }

        if(first==s1.length() && second == s2.length()) return true;

        return false;
    }
    

}