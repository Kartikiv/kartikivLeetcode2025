class Solution {
    public int majorityElement(int[] nums) {
        int majorCandidate = 0;
        int count = 0 ;
        for(int num : nums){
            if(count == 0) {
                majorCandidate = num;
            }
            count = num == majorCandidate ? count + 1 : count - 1;
        }
   return majorCandidate; }
}