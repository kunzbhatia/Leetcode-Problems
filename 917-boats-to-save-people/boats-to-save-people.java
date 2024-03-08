class Solution {
    public int numRescueBoats(int[] people, int limit) 
    {
        Arrays.sort(people);
        int n=people.length-1;
        int left=0,right=n;
        int count=0;
        while(left<right)
        {
            if(people[left]+people[right]>limit)
            {
                count++;
                right--;
            }
            else
            {
                count++;
                right--;
                left++;
            }
            if(left==right)
            {
                count++;
                right--;
                left++;

            }
            
        }
        return count;

    }
}