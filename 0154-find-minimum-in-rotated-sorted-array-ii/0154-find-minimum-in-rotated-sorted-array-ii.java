class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] > nums[j]) {
                // Minimum is on the right side
                i = mid + 1;
            } else if (nums[mid] < nums[j]) {
                // Minimum is at mid or on the left side
                j = mid;
            } else {
                // nums[mid] == nums[j]
                // Cannot decide, so shrink right boundary safely
                j--;
            }
        }

        return nums[i];
    }
}