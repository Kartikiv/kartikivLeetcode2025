import java.util.*;
class Solution {
    public int pivotIndex(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int total = 0; 
        for(int num : nums){
            total += num; 
        }
        // rightsum = totalSum - leftSum - nums[i]
        // 1 ,2 ,3, 4, 5, 6  total : 21 at 4 leftSum = 6 rightsum = 21 - 6 - 4 = 11 
        // find the left sum incrementally
        int leftSum = 0; 
        for(int i = 0 ; i < nums.length; i++){
            if(leftSum == total - leftSum - nums[i]){
                ans.add(i);
            }
            leftSum += nums[i];
        }
        System.out.println(ans);

    return ans.size() == 0 ? -1 : ans.get(0) ; 
}
}