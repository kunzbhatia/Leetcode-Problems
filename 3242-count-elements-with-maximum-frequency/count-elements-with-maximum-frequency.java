class Solution {
    public int maxFrequencyElements(int[] nums) {
        int a[]=new int[101];
        for(int i:nums)
        {
            a[i]++;
        }

        int maxi=0;
        for(int i=0;i<=100;i++)
        {
            maxi=Math.max(maxi,a[i]);
        }
        int ans=0;

        for(int i=0;i<=100;i++)
        {
            if(a[i]==maxi)
            {
                ans+=maxi;
            }
        }
        
        return ans;
    }
}




// public class Solution {
//     public int maxFrequencyElements(int[] nums) {
//         // Step 1: Frequency Calculation
//         Map<Integer, Integer> um = new HashMap<>();
//         for (int x : nums) 
//          {
//             um.put(x, um.getOrDefault(x, 0) + 1);
//           }

//         // Step 2: Find Maximum Frequency
//         int maxi = 0;
//         for (int value : um.values()) 
//          {
//             maxi = Math.max(maxi, value);
//         }

//         // Step 3: Calculate Total Frequency with Maximum Frequency
//         int ans = 0;
//         for (int value : um.values()) 
//          {
//             if (value == maxi) 
//              {
//                 ans += value;
//             }
//         }

//         // Step 4: Return Result
//         return ans;
//     }
// }