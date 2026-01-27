/**
 * Finds the length of the longest consecutive sequence in an unsorted array of integers.
 * This method uses a HashSet to achieve O(n) time complexity. It first adds all numbers
 * to the set, then iterates through the set to find the start of each sequence (a number
 * whose predecessor is not in the set). For each such start, it counts the length of the
 * consecutive sequence. The search can terminate early if the longest streak found so far
 * is at least half the length of the input array plus one.
 * @param nums the input array of integers
 * @return the length of the longest consecutive sequence
 */
import java.util.HashSet;

class Solution {
 
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