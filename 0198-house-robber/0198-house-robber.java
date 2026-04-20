class Solution {
    int firstPrevious;
    int secondPrevious;

    public int rob(int[] nums) {
        // I need to see what is the optimal way 
        // backtrack is a brute force approach 
        // lets first implement backtracking 
        // now think about memoization of the solution 
        // base case
        if(nums.length == 0) throw new IllegalArgumentException("Empty Data");
        if(nums.length == 1) return nums[0];
        this.firstPrevious = nums[0];
        this.secondPrevious = Math.max(nums[0],nums[1]);
        return backtrack(2, nums);
    }

    int backtrack(int index, int[] nums) {
        //  i need make a choice to rob or not to rob a house
        // base cases
        if(index == nums.length) return secondPrevious;
        int temp = firstPrevious;
        firstPrevious = secondPrevious;
        secondPrevious = Math.max(secondPrevious, temp + nums[index]);
        backtrack(index + 1, nums);
        return secondPrevious;

    }
}