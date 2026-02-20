
import java.util.HashMap;

class NumArray {
    HashMap<Integer, Integer> map;

    public NumArray(int[] nums) {
        this.map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(i, sum);

        }

    }

    public int sumRange(int left, int right) {
        return map.getOrDefault(right, 0) - map.getOrDefault(left - 1, 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */