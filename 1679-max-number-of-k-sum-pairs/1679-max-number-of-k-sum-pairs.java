class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k - nums[i])) {
                int count = map.get(k - nums[i]) - 1;
                if (count == 0) {
                    map.remove(k - nums[i]);
                }else{
                    map.put(k - nums[i], count);
                }
                ans++;
            }else{
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return ans;
    }
}