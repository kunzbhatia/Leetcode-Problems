class Solution 
{
    //GREEDY LOGIC
    public int leastInterval(char[] tasks, int n) 
    {
        if(n==0)
        {
            return tasks.length;
        }
        int[] freq = new int[26];
        for(char task:tasks)
        {
            freq[task-'A']++;
        }
        Arrays.sort(freq);
        int chunk=freq[25]-1; //highest frequency
        int idle= chunk * n; 

        for(int i=24;i>=0;i--)
        {
            idle-=Math.min(chunk,freq[i]);
        }
        return idle < 0 ? tasks.length : tasks.length + idle;

    }
}