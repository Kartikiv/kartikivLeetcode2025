class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -1 * nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[k] + nums[j] > target) {
                    k--;
                } else if (nums[k] + nums[j] < target) {
                    j++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}