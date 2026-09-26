import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return nSum(nums, 3, 0, 0);
    }

    public List<List<Integer>> nSum(
            int[] nums,
            int n,
            long target,
            int index) {

        List<List<Integer>> ans = new ArrayList<>();

        // Base case: 2-sum
        if (n == 2) {
            int j = index;
            int k = nums.length - 1;

            while (j < k) {
                long sum = (long) nums[j] + nums[k];

                if (sum < target) {
                    int left = nums[j];

                    while (j < k && nums[j] == left) {
                        j++;
                    }

                } else if (sum > target) {
                    int right = nums[k];

                    while (j < k && nums[k] == right) {
                        k--;
                    }

                } else {
                    ans.add(new ArrayList<>(
                            Arrays.asList(nums[j], nums[k])
                    ));

                    int left = nums[j];
                    int right = nums[k];

                    while (j < k && nums[j] == left) {
                        j++;
                    }

                    while (j < k && nums[k] == right) {
                        k--;
                    }
                }
            }

            return ans;
        }

        // Recursive n-sum
        for (int i = index; i <= nums.length - n; i++) {

            // Skip duplicate choice at this recursion level
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> temp =
                    nSum(nums, n - 1, target - nums[i], i + 1);

            for (List<Integer> list : temp) {
                List<Integer> current = new ArrayList<>();

                current.add(nums[i]);
                current.addAll(list);

                ans.add(current);
            }
        }

        return ans;
    }
}