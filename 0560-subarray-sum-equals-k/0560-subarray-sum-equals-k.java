class Solution {
    public int subarraySum(int[] nums, int k) {
        // we maintain a running sum and see we have encountered currentSum - k
        // we also maintain the frequency count of the encountered variables 
        // if encountered the same sum twice we store sum -> frequency of occurence. 
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int count = 0;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            count += sumMap.getOrDefault(currentSum - k, 0);
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}