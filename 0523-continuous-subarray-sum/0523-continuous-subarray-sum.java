import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        maps.put(0, -1);
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            sum += num;
            int rem = k == 0 ? sum : sum % k;
            if (maps.containsKey(rem)) {
                if (j - maps.get(rem) >= 2)
                    return true;
            } else {
                maps.put(rem, j);
            }
        }
        return false;
    }
}
