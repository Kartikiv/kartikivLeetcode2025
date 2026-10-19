class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (tails.isEmpty() || tails.get(tails.size() - 1) < nums[i]) {
                tails.add(nums[i]);
            } else {
                int low = 0;
                int high = tails.size() - 1;
                while (low < high) {
                    int mid = low + (high - low) / 2;
                    if (tails.get(mid) < nums[i]) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
            tails.set(high, nums[i]);
            }

        }
        return tails.size();
    }
}