/**
 * Searches for a target value in a rotated sorted array.
 *
 * The array is assumed to be:
 *  - Sorted in ascending order
 *  - Rotated at an unknown pivot
 *  - Contains NO duplicate elements
 *
 * Example:
 *   Input:  nums = [4,5,6,7,0,1,2], target = 0
 *   Output: 4
 *
 * Strategy:
 *  1. Find the index of the minimum element (rotation pivot).
 *  2. Perform binary search on the two sorted subarrays.
 *
 * Time Complexity:
 *  - Pivot search: O(log n)
 *  - Binary search: O(log n)
 *  - Total: O(log n)
 *
 * Space Complexity:
 *  - O(1) (constant extra space)
 */
class Solution {

    /** Reference to the input array for internal helper methods */
    private int[] nums;

    /**
     * Searches for the given target in the rotated sorted array.
     *
     * @param nums   Rotated sorted array (no duplicates)
     * @param target Value to search for
     * @return Index of target if found, otherwise -1
     */
    public int search(int[] nums, int target) {
        this.nums = nums;

        // Step 1: Find index of the smallest element (rotation pivot)
        int pivot = findMinIndex();

        // Step 2: Binary search on both sorted halves
        int right = binarySearch(pivot, nums.length - 1, target);
        int left  = binarySearch(0, pivot, target);

        return left == -1 ? right : left;
    }

    /**
     * Standard binary search on a sorted subarray.
     *
     * Invariant:
     *  - If target exists, it is always within [i, j].
     *
     * @param i      Left boundary (inclusive)
     * @param j      Right boundary (inclusive)
     * @param target Value to search for
     * @return Index of target if found, otherwise -1
     */
    private int binarySearch(int i, int j, int target) {
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Finds the index of the minimum element in a rotated sorted array.
     *
     * Key invariant:
     *  - The minimum element always lies within the range [i, j].
     *  - nums[j] always belongs to the right (smaller) sorted segment.
     *
     * Decision logic:
     *  - If nums[mid] > nums[j], the minimum is strictly to the right of mid.
     *  - Otherwise, the minimum is at mid or to the left of mid.
     *
     * @return Index of the minimum element (rotation pivot)
     */
    private int findMinIndex() {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }
}
