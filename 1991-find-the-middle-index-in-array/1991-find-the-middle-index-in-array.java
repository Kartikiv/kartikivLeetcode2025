import java.util.HashMap;

class Solution {
    public int findMiddleIndex(int[] nums) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maps.put(i, sum);
        }
        for (int i = 0; i < nums.length; i++) {
            if(maps.get(i) == maps.get(nums.length - 1) - maps.getOrDefault(i - 1, 0)){
                return i ;
            }
        }


   return -1; }
}