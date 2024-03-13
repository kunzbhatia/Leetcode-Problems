class Solution {
    public int pivotInteger(int n) 
    {
        int i=1,j=n;
        int suml=i,sumr=j;
        while(i<j)
        {
            if(suml<sumr) 
            {
                i++;
                suml=suml+i;
            }
            else 
            {
                j--;
                sumr=sumr+j;
            }    
        }
        if(suml==sumr)
        {
            return i;
        }
        return -1;

    }
}