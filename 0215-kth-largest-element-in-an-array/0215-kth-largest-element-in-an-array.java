class Solution {
    public int findKthLargest(int[] nums, int k) {
       int i = 0; 
       int j = nums.length - 1 ;
       int target = nums.length - k; 
       while(i <= j){ 
        int [] index = partion(nums, i, j); 
        int lt = index[0];
        int rt = index[1];
        if(target < lt){
            j = lt - 1; 
        }
        else if(target > rt){
            i = rt + 1;
        }else{
            return nums[rt];
        }
       }
    return -1 ;}
    public int [] partion(int [] nums , int l, int r){
        // Select the pivot index
        int pivotIndex = ThreadLocalRandom.current().nextInt(l, r + 1);
        int pivot = nums[pivotIndex];
        // maintain two pointer 
        int i = l ;
        int lt = l; 
        int rt = r;

        while (i <= rt) {
            if(nums[i] < pivot){
                swap(nums, i, lt);
                lt++;
                i++;
            }else if(nums[i] > pivot){
                swap(nums, i, rt);
                rt--;
                // do not increment i as it belongs to unknown part
            }
            else{ 
                i++;
            }

        }


    return new int []{lt,rt}; 
    }
    void swap(int [] nums, int a, int b){ 
        int temp = nums[a];
        nums[a] = nums[b]; 
        nums[b] = temp;
    }
}
