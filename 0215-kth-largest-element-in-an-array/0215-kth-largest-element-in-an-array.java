import java.util.concurrent.ThreadLocalRandom;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int[] mid = partition3(nums, l, r);
            int lt = mid[0], gt = mid[1];

            if (target < lt) {
                r = lt - 1;
            } else if (target > gt) {
                l = gt + 1;
            } else {
                return nums[target];
            }
        }

        return -1;
    }

    private int[] partition3(int[] nums, int l, int r) {
        int pivotIndex = ThreadLocalRandom.current().nextInt(l, r + 1);
        int pivot = nums[pivotIndex];

        int lt = l;
        int i = l;
        int gt = r;

        while (i <= gt) {
            if (nums[i] < pivot) {
                swap(nums, lt, i);
                lt++;
                i++;
            } else if (nums[i] > pivot) {
                swap(nums, i, gt);
                gt--;
            } else {
                i++;
            }
        }

        return new int[]{lt, gt};
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}