
import java.util.concurrent.ThreadLocalRandom;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int l = 0 ; 
        int r = nums.length - 1;
        while (l <= r) {
            int [] indecies = partition(nums, l, r);
            if(target < indecies[1]){
                r = indecies[1] - 1 ;
            }else if(target > indecies[2]){
                l = indecies[2] + 1;
            }else{
                return nums[target];
            }
        }
        
    return -1 ; 
}
    int [] partition (int [] nums, int l , int r){
        // select a random pivot 
        int pivotIndex = ThreadLocalRandom.current().nextInt(l , r + 1);
        int pivot = nums[pivotIndex];
        // partition the array
        int lt = l;
        int i = l;
        int gt = r; 
        while (i <= gt) {
            // ith number < pivot swap left and move i right
            if(nums[i] < pivot){
                swap(nums, i, lt);
                lt++;
                i++;
            }
            // ith element is greater than pivot swap i and gt do not move i as it below to an unknown region
            else if(nums[i] > pivot){
                swap(nums, i, gt);
                gt--;
            }else{
                i++;
            }
        }
    return  new int[]{i, lt,gt}; 
}
    // swap util 
    void swap(int [] nums, int l , int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}