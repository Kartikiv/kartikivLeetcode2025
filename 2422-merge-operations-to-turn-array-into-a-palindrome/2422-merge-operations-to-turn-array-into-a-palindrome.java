class Solution {
    public int minimumOperations(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int leftval = nums[left];
        int rightVal = nums[right];
        int operations = 0;
        while (left < right) {
            // states to track 
            // equal move them both 
            // not equal merge small part 
            // i.e leftVal smaller than rightVal merge left 
            // else merge right val
            if (leftval == rightVal) {
                // move both
                left += 1;
                right -= 1;
                leftval = nums[left];
                rightVal = nums[right];
            } else if (leftval < rightVal) {
                left += 1;
                // merge left
                leftval += nums[left];
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