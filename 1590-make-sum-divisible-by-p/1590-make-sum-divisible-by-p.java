import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) totalSum += num;

        int target = (int)(totalSum % p);
        if (target == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // critical: allows removing a prefix

        long prefix = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int curRem = (int)(prefix % p);

            int need = (curRem - target) % p;
            if (need < 0) need += p;

            Integer j = map.get(need);
            if (j != null) {
                minLen = Math.min(minLen, i - j);
            }

            map.put(curRem, i);
        }

        return minLen == nums.length ? -1 : minLen;
    }
}