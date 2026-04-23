class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // sum is closet and sometimes can be equal to the target 
        // so the target is alteast target - nums[i] also can we greater as well
        // when we sort an array
        /* 
         [-4, -1, 1, 2]
         */
         Arrays.sort(nums); // nlogn
         int minPossibleSum = nums[0] + nums[1] + nums[2];
         for (int i = 0; i < nums.length ; i++){ 
            int value = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1 ;
            while(left < right){ 
                minPossibleSum = Math.abs(minPossibleSum - target) > Math.abs(target - (nums[left] + nums[right] + nums[i])) ? nums[left] + nums[right] + nums[i] : minPossibleSum;
                if(nums[left] + nums[right] == value){ 
                    return target;
                }
                if(nums[left] + nums[right] < value){
                    left++;
                }else{ 
                    right--;
                }
            }
         }

    return minPossibleSum; 
    }
}