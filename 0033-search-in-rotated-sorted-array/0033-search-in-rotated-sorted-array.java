class Solution {
    // One method is the we can search the pivot and then find the element in left half or the right half 
    // The second option is that we known that the everytime we find a mid we are effectively diving the array into 
    // two part one part is always sorted and the other part is not sorted
    // then we check if the element belongs to the sorted part or the unsorted part 
    // then search continues till we find the element in this way we are optimize the traversal to a one pass rather
    // than a two pass
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = right + (left - right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Check if the left half is sorted
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            } else { // Then the right half is sorted
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}