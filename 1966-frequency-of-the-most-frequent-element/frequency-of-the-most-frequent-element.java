
class Solution
 {
    public int maxFrequency(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for (int num : nums) 
        {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> numsList = new ArrayList<>(freqMap.keySet());
        Collections.sort(numsList);
        
        int maxCount = 0;
        int n = numsList.size();
        
        for (int i = n-1; i >= 0; i--) 
        {
            int count = freqMap.get(numsList.get(i));   // start with frequency of nums.get(i), as we don't have to do any operation
            int curFreq = k;
            int j = i - 1;
            
            while (j >= 0 && curFreq >= (numsList.get(i) - numsList.get(j))) 
            {
                int diff = numsList.get(i) - numsList.get(j);
                int diffFreq = curFreq / diff;
                
                if (diffFreq > freqMap.get(numsList.get(j))) 
                {
                    count += freqMap.get(numsList.get(j));
                    curFreq -= freqMap.get(numsList.get(j)) * diff;
                } 
                else
                 {
                    count += diffFreq;
                    curFreq -= diffFreq * diff;
                }
                j--;
            }
            
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
 }