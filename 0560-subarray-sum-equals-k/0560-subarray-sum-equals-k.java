import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preFixMap = new HashMap<>();
        int sum = 0;
        int ans = 0;
        // Empty subarraySum = 0
        preFixMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            ans += preFixMap.getOrDefault(sum - k, 0);  
            preFixMap.put(sum, preFixMap.getOrDefault(sum, 0) + 1);



            
        }
    return ans; }
}