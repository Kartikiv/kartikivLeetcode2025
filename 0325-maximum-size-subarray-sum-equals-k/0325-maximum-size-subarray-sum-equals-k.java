import java.util.HashMap;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum))
                map.put(sum, i);
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(i - map.get(sum - k), maxLen);
            }
        }
        return maxLen;
    }
}