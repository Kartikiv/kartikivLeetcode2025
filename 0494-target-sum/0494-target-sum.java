class Solution {
    int count = 0 ;
    HashMap<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
    return backTracking(nums, 0, target);
    }
    public int backTracking(int [] nums , int index, int target){
         if (index == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        Pair<Integer, Integer> key = new Pair<>(index, target);
        Integer cached = memo.get(key);
        if (cached != null) return cached;

        /*
         Choice 1: put '+' before nums[index]  => remaining target decreases
         Choice 2: put '-' before nums[index]  => remaining target increases
        */
        int ways =
            backTracking(nums, index + 1, target - nums[index]) +
            backTracking(nums, index + 1, target + nums[index]);

        memo.put(key, ways);
        return ways;


    }
}