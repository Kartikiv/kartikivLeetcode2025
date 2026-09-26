class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -1 * nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[k] + nums[j] > target) {
                    int num = nums[k];
                    while (k >= j && num == nums[k]) {
                        k--;
                    }
                } else if (nums[k] + nums[j] < target) {
                    int num = nums[j];
                    while ( j <= k && num == nums[j]) {
                        j++;
                    }
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    int num = nums[k];
                    while (k >= j && num == nums[k]) {
                        k--;
                    }
                    num = nums[j];
                    while ( j <= k && num == nums[j]) {
                        j++;
                    }
                }
            }
        }
        return ans;
    }
}