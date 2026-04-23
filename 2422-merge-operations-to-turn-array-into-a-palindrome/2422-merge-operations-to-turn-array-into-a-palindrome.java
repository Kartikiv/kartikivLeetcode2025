class Solution {
    public int minimumOperations(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int leftVal = nums[left];
        int rightVal = nums[right];
        int operations = 0;
        while (left < right) {
            // states to track 
            // equal move them both 
            // not equal merge small part 
            // i.e leftVal smaller than rightVal merge left 
            // else merge right val
            if (leftVal == rightVal) {
                // move both
                left += 1;
                right -= 1;
                leftVal = nums[left];
                rightVal = nums[right];
            } else if (leftVal < rightVal) {
                left += 1;
                // merge left
                leftVal += nums[left];
                operations++;
            } else {
                right -= 1;
                rightVal += nums[right];
                operations++;
            }
        }
    return operations; 
    }
}