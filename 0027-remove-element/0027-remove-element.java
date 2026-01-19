class Solution {
    public int removeElement(int[] nums, int val) {
        int right = nums.length - 1;
        int i = 0;

        while (i <= right) {
            if (nums[i] == val) {
                // Skip all val from right
                while (right >= 0 && nums[right] == val) {
                    right--;
                }

                if (i > right) break;

                // Swap
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;

                right--; // move boundary
            } else {
                i++; // only move i if value is valid
            }
        }

        return right + 1;
    }
}
