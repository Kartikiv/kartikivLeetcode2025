
import java.util.Arrays;

class Solution {
    int[][] memo;

    // we need to partion the array into equal sums
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        this.memo = new int[nums.length + 1][sum / 2 + 1];
        if (sum % 2 != 0) {
            return false;
        }
        return bactrack(0, nums, 0 ,sum / 2);
    }

    public boolean bactrack(int index, int[] nums, int sum, int target) {
        if(target < sum) {
           return false;
        }
        if (memo[index][sum] != 0) {
            return memo[index][sum] == 1;
        }
        if (sum == target) { // reached a path where the sum is exactly half of the total sum
            return true;
        }
        if (nums.length == index) {
            return false;
        }
        // i include or not include
        // include
        boolean include = bactrack(index + 1, nums, sum + nums[index], target);
        // exclude
        boolean exclude = bactrack(index + 1, nums, sum, target);
        memo[index][sum] = include || exclude == true ? 1 : 2;
        return memo[index][sum] == 1;
    }
}