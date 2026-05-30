class Solution {
    public int tupleSameProduct(int[] nums) {
      // create a product map 
      HashMap<Integer,Integer> productMap = new HashMap<>(); 
      for(int i = 0 ; i < nums.length; i++){ 
        for (int j = i + 1; j < nums.length; j++){ 
           productMap.put(nums[i] * nums[j], productMap.getOrDefault(nums[i] * nums[j], 0) + 1);
        }
      }
      int ans = 0 ; 
      for(int key : productMap.keySet()){
        int n = productMap.get(key);
        ans += (n * (n - 1)) * 4;
      } 


    return ans; }
}
// [1,2] 3 * 2 * 2 * 2