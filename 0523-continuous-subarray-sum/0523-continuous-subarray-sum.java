import java.util.*;
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // if we have seen the reminder before we know that the total - seen reminder is 
        // divisible by 6 
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0 ; 
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; 
            map.put(0,0);
            if(map.containsKey(sum % k)){
                if(i - map.get(sum % k) + 1 >= 2)
                return  true;
            }
            map.putIfAbsent(sum % k, i + 1);
        }

    return false; 
}
}