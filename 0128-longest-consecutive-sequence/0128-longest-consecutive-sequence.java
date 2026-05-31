class Solution {
    public int longestConsecutive(int[] nums) {
        // No extra space 
        if(nums.length == 0 ) return 0;
        Arrays.sort(nums);
        int finalCount = 1; 
        int i = 0  ;
       while(i < nums.length - 1){
            int count = 1 ;
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]){ 
                count++;
                i++;
                while(i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
            finalCount = Math.max(count, finalCount);
            i++;
        }
    return finalCount; 
    }
}