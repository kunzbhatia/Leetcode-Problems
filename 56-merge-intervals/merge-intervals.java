class Solution {
    public int[][] merge(int[][] intervals) {
    
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // if the ans list is empty or if the current interval's start is greater than
            // the end of the last interval in ans, add a new interval to ans
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) 
            {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            // if the current interval overlaps with the last interval in ans,
            // update the end of the last interval in ans if necessary
            else 
            {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
            }
        }
        int[][] result=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++)
        {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }
        return result;
    }
}