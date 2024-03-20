class Solution {
    public String reorganizeString(String s) 
    {
        int n=s.length();
        Map<Character,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mpp.put(s.charAt(i),mpp.getOrDefault(s.charAt(i),0)+1);
        }

        char maxFreqChar='-';
        int maxFreq=0;
        for(char c: mpp.keySet())
        {
            if(mpp.get(c)>maxFreq)
            {
                maxFreq=mpp.get(c);
                maxFreqChar=c;
            }
        }
        if(maxFreq > (s.length()+1)/2)
        {
            return "";
        }

        char[] result=new char[s.length()];
        int  index=0;

        for(int i=0;i<maxFreq;i++)
        {
            result[index]=maxFreqChar;
            index+=2;
        }

        mpp.remove(maxFreqChar);

        for(char c: mpp.keySet())
        {
            if(index>=s.length())
            {
                index=1;
            }
            for(int i=0;i<mpp.get(c);i++)
            {
                if(index>=s.length())
                {
                    index=1;
                }
                result[index]=c;
                index+=2;
            }
        }

        return new String(result);


        
        

    }
}