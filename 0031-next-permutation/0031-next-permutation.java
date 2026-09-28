class Solution {
    public void nextPermutation(int[] nums) {
        // from the right find the first smallest number and 
        // swap the element with the smallest elememnt 
         int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // then we find the first element greter than the nums[i - 1]
        if(i >= 0){
        int j = nums.length - 1 ; 
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }

        // swap j , i 
        swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
      private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

       private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}