import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        nSum(nums, 3, 0L, 0, path, ans);

        return ans;
    }

    private void nSum(
            int[] nums,
            int n,
            long target,
            int index,
            List<Integer> path,
            List<List<Integer>> ans) {

        if (n == 2) {
            int left = index;
            int right = nums.length - 1;

            while (left < right) {
                long sum = (long) nums[left] + nums[right];

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    List<Integer> result = new ArrayList<>(path);
                    result.add(nums[left]);
                    result.add(nums[right]);

                    ans.add(result);

                    int leftValue = nums[left];
                    int rightValue = nums[right];

                    while (left < right && nums[left] == leftValue) {
                        left++;
                    }

                    while (left < right && nums[right] == rightValue) {
                        right--;
                    }
                }
            }

            return;
        }

        for (int i = index; i <= nums.length - n; i++) {

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);

            nSum(
                nums,
                n - 1,
                target - nums[i],
                i + 1,
                path,
                ans
            );

            path.remove(path.size() - 1);
        }
    }
}