import java.util.Arrays;
class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        int n=nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int moreNeeded = target - num;
            if (mpp.containsKey(moreNeeded)) 
            {
                ans[0] = mpp.get(moreNeeded);
                ans[1] = i;
                return ans;
            }

            mpp.put(nums[i], i);
        }
        return ans;
    }
}