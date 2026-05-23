class Solution {
    public boolean check(int[] nums) {
        // base case
        if(nums.length == 1) return true;
        // if an array is sorted and rotated 
        // what are the contidions that remain true ?? 
        // rotation means we encounter a pivot i.e we encounter a smaller number in the sequence 
        // after the encoiuntering the pivot all the elements after the pivot are smaller that the largest number 
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int previousNumber = nums[0];
        boolean encounteredPivot = false;
        for (int i = 0; i < nums.length; i++) {
            // if nums[i] > previous number go on
            if(nums[i] < previousNumber){ 
                if (encounteredPivot) return false; 
                encounteredPivot = true; 
                
            } if(encounteredPivot && (nums[i] > maxSoFar || nums[i] > minSoFar)){ 
                return false;
            }else { 
                if(!encounteredPivot){ 
                    maxSoFar = nums[i];
                    
                }
            }
            previousNumber = nums[i];
        }
    return true; 
    }
}