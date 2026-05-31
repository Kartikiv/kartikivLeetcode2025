class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> reminderMap = new HashMap<>(); 
        reminderMap.put(0, -1);
        int sum = 0; 
        for(int i = 0 ; i < nums.length; i++){ 
            sum += nums[i];
            int reminder = sum % k ; 
            if(reminderMap.containsKey(reminder) && i - reminderMap.get(reminder) >= 2) return true;
            // add the reminder to the map 
            reminderMap.putIfAbsent(reminder, i);
        }
    return false; 
    }
}