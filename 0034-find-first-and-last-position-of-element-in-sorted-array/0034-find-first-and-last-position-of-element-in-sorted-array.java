class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int first = lowerBound(nums, target);   // first >= target
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }

        int upper = upperBound(nums, target);   // first > target
        return new int[]{first, upper - 1};
    }

    // first index where nums[idx] >= target
    private int lowerBound(int[] nums, int target) {
        int i = 0, j = nums.length; // [i, j)
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] >= target) j = mid;
            else i = mid + 1;
        }
        return i;
    }

    // first index where nums[idx] > target
    private int upperBound(int[] nums, int target) {
        int i = 0, j = nums.length; // [i, j)
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > target) j = mid;
            else i = mid + 1;
        }
        return i;
    }
}
