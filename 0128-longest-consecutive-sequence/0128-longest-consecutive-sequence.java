class Solution {
    public int longestConsecutive(int[] nums) {
        // start from the beginning
        int finalCount = 0;
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            // if we are the begining of the sequence
            if (!numSet.contains(nums[i] - 1)) {
                int num = nums[i];
                int count = 0;
                while (numSet.contains(num)) {
                    count++;
                    num++;
                }
                finalCount = Math.max(count, finalCount);
                if (finalCount > nums.length / 2)
                    return finalCount;
            }
        }

        return finalCount;
    }
}