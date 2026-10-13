class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return kSum(nums, 3, 0, 0);
    }

    private List<List<Integer>> kSum(
        int[] nums,
        int k,
        int index,
        long target
    ) {
        List<List<Integer>> ans = new ArrayList<>();

        if (k == 2) {
            return twoSum(nums, index, target);
        }

        for (int i = index; i <= nums.length - k; i++) {

            // Skip duplicate choices at this recursion level
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> subLists =
                kSum(nums, k - 1, i + 1, target - nums[i]);

            for (List<Integer> list : subLists) {
                List<Integer> current = new ArrayList<>();
                current.add(nums[i]);
                current.addAll(list);

                ans.add(current);
            }
        }

        return ans;
    }

    private List<List<Integer>> twoSum(
        int[] nums,
        int index,
        long target
    ) {
        List<List<Integer>> ans = new ArrayList<>();

        int left = index;
        int right = nums.length - 1;

        while (left < right) {

            long sum = (long) nums[left] + nums[right];

            if (sum == target) {

                ans.add(Arrays.asList(
                    nums[left],
                    nums[right]
                ));

                left++;
                right--;

                // Skip duplicate left values
                while (
                    left < right &&
                    nums[left] == nums[left - 1]
                ) {
                    left++;
                }

                // Skip duplicate right values
                while (
                    left < right &&
                    nums[right] == nums[right + 1]
                ) {
                    right--;
                }

            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}