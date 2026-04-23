import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, (long) target);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int k, long target) {
        List<List<Integer>> res = new ArrayList<>();

        if (k == 2) {
            int l = start, r = nums.length - 1;
            while (l < r) {
                long sum = (long) nums[l] + nums[r];
                if (sum == target) {
                    res.add(Arrays.asList(nums[l], nums[r]));
                    l++; r--;
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
            return res;
        }

        for (int i = start; i <= nums.length - k; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            for (List<Integer> subset : kSum(nums, i + 1, k - 1, target - nums[i])) {
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(nums[i]);
                cur.addAll(subset);
                res.add(cur);
            }
        }
        return res;
    }
}
