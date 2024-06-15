class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) 
    {
        int n=profits.length;
        int [][] project=new int[n][2];
        for(int i=0;i<n;i++)
        {
            project[i][0]=capital[i];
            project[i][1]=profits[i];
        }

        Arrays.sort(project, (a,b) -> Integer.compare(a[0],b[0])); //sort projects based on captitals

        int i=0;
        PriorityQueue<Integer> maximizeCapital= new PriorityQueue<>(Collections.reverseOrder()); //max heap definition


        while(k>0) //base case till k projects are taken
        {
            while(i<n && project[i][0]<=w) //until all projects under w are taken
            {
                maximizeCapital.offer(project[i][1]); //adding profit of respective capital
                i++;
            }

            if(maximizeCapital.isEmpty())
            {
                break;
            }

            w=w+maximizeCapital.poll();
            k--;
        }
        return w;
        
    }
}