class Solution {
    public int missingNumberFormula(int[] nums) {
        int n = nums.length; 
        int sum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for(int num: nums){
            actualSum += num;
        }
    return sum - actualSum;
    }
    public int missingNumber(int [] nums){
        int sum = 0; 
        int n = 1;
        for (int num : nums){
            sum = sum^num^n;
            n++;
        }

    return sum;}
}