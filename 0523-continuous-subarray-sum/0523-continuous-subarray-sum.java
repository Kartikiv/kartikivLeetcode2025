class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderIndex = new HashMap<>();
        remainderIndex.put(0, -1); // handles subarrays starting at index 0

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = k == 0 ? sum : sum % k;

            if (remainderIndex.containsKey(rem)) {
                if (i - remainderIndex.get(rem) >= 2) {
                    return true;
                }
            } else {
                remainderIndex.put(rem, i); // store first occurrence only
            }
        }
        return false;
    }
}
