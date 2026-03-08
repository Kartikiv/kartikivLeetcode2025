import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new ArrayList<>());
        return ans;
    }

    void dfs(int[] nums, boolean[] used, List<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            list.add(nums[i]);

            dfs(nums, used, list);

            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}