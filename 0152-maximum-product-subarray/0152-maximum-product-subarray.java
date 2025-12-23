// made this solution o(1) space 
// o(n) time complexity
// simply doing dynamic i.e look what is the max till now will not help as we are dealing with negative numbers. 
// so we also caliculate the maxProd and minProd


class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int maxProd = Integer.MIN_VALUE;
        int minProd = Integer.MAX_VALUE;
        maxProd = nums[0];
        minProd = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax= maxProd;
            int tempMin = minProd;
            maxProd = max(nums[i], nums[i] * tempMax, nums[i] * tempMin);
            minProd = min(nums[i], nums[i] * tempMax, nums[i] * tempMin);
            ans = Math.max(ans, maxProd);
        }
        return ans;
    }

    public int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}