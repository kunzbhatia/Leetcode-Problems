class Solution {
    public int findContentChildren(int[] g, int[] s) 
    {
        Arrays.sort(g);
        Arrays.sort(s);
        int n=g.length;
        int m=s.length;

        int l=0,r=0; //two pointers

        while(r<n && l<m) // no. of cookies
        {
            if(g[r]<=s[l])
            {
                r++;
            }
            l=l+1;
        }
        return r;

    }
}