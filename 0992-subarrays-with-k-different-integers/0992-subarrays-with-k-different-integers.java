
import java.util.HashMap;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

    return  slidingWindowAtMostk(nums, k) - slidingWindowAtMostk(nums, k - 1); 
}

    int slidingWindowAtMostk(int[] nums, int k) {
        HashMap<Integer, Integer> set = new HashMap<>();
        int maxLen = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            set.put(nums[j], set.getOrDefault(nums[j], 0) + 1);
            while (set.size() > k) {
                int freq = set.getOrDefault(nums[i], 0);
                freq = freq - 1;
                if (freq == 0) {
                    set.remove(nums[i]);
                } else {
                    set.put(nums[i], freq);
                }
                i++;
            }
            maxLen += j - i + 1;
        }
        return maxLen;
    }
}