class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int secondPreviousHouse = nums[0];
        int previousHouse = Math.max(nums[0], nums[1]);

        int secondPreviousHouse1 = 0;
        int previousHouse1 = nums[1];

        for (int i = 2; i < nums.length; i++) {
            int temp = previousHouse;
            if(i < nums.length - 1){
            previousHouse = Math.max(previousHouse, secondPreviousHouse + nums[i]);
            secondPreviousHouse = temp;
            }

            temp = previousHouse1;
            previousHouse1 = Math.max(previousHouse1, secondPreviousHouse1 + nums[i]);
            secondPreviousHouse1 = temp;
        }
        return Math.max(previousHouse1, previousHouse);
    }
}