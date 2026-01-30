import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int right = 0;

        int distinctRemaining = k; // how many new distincts we can still add
        int duplicatePrefix = 0;  // how many times we can move left over duplicates
        int ans = 0;

        while (right < nums.length) {

            // 1) expand window by adding nums[right]
            int x = nums[right];
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            if (freq.get(x) == 1) distinctRemaining--; // new distinct added
            right++;

            // 2) too many distinct -> shrink once until we’re back to <= k
            if (distinctRemaining < 0) {
                int y = nums[left];
                freq.put(y, freq.get(y) - 1);
                if (freq.get(y) == 0) freq.remove(y);
                left++;

                distinctRemaining++;   // we removed one distinct type from the window
                duplicatePrefix = 0;   // reset because left boundary changed “for real”
            }

            // 3) exactly k distinct -> compress duplicates on the left and count
            if (distinctRemaining == 0) {
                while (freq.get(nums[left]) > 1) {
                    int y = nums[left];
                    freq.put(y, freq.get(y) - 1);
                    left++;
                    duplicatePrefix++;
                }
                ans += (duplicatePrefix + 1);
            }
        }

        return ans;
    }
}
