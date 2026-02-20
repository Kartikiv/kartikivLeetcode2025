
import java.util.HashMap;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int maxArrSum = 0 ;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            sum += nums[j];
            while(map.size() != j - i + 1){
                int freq = map.getOrDefault(nums[i], 0);
                freq = freq - 1; 
                if(freq <= 0){
                    map.remove(nums[i]);
                }else{
                    map.put(nums[i], freq);
                }
                sum -= nums[i];
                i++;
            }
            maxArrSum = Math.max(maxArrSum, sum);
        }
    return maxArrSum; 
}
}