import java.util.HashSet;

class Solution {
    /**
     * 
     * @param nums array of integers
     * @return length of the longest consecutive elements sequence
     * starting from any number in the array check if it's the start of a sequence
     * if it is, count the length of the sequence
     * update the longest streak found  
     * Time complexity: O(n)
     * Space complexity: O(n)
     * 
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
                if (longestStreak >= nums.length / 2 + 1) {
                    break;
                }
            }

        }

        return longestStreak;
    }
}