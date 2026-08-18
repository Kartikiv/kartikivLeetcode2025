class Solution {
    public int largestInteger(int[] nums, int k) {
        // observation almost all the integer that are not at the begining or at the end will appear twice
        // if the k < nums.length else
        int [] countMap = new int [51];
        int maxNumTotal = -1;
        for(int num : nums){ 
            countMap[num]++;
            maxNumTotal = Math.max(maxNumTotal, num);
        }
        if(k == nums.length){ 
            return maxNumTotal;
        }
        if (k == 1){ 
            int maxNum = -1; 
            for(int i = 0; i < countMap.length; i++){ 
                if(countMap[i] == 1){ 
                    maxNum = Math.max(i, maxNum); 
                }
            }
            return maxNum;
        }
        if(k < nums.length){
            if(countMap[nums[0]] != 1 && countMap[nums[nums.length -1]] == 1){
                return nums[nums.length -1];
            }
            if(countMap[nums[nums.length - 1]] != 1 && countMap[nums[0]] == 1){
                return nums[0];
            }
            if(countMap[nums[nums.length - 1]] != 1 && countMap[nums[0]] != 1){
                return -1;
            }
            
            return Math.max(nums[0], nums[nums.length-1]);
        }
    return -1; 
    }
}