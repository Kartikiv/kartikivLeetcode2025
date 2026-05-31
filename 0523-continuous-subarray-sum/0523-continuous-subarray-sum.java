class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> remainderMap = new HashMap<>(); 
        remainderMap.put(0, -1);
        int sum = 0; 
        for(int i = 0 ; i < nums.length; i++){ 
            sum += nums[i];
            int remainder = sum % k ; 
            if(remainderMap.containsKey(remainder) && i - remainderMap.get(remainder) >= 2) return true;
            // add the remainder to the map 
            remainderMap.putIfAbsent(remainder, i);
        }
    return false; 
    }
}