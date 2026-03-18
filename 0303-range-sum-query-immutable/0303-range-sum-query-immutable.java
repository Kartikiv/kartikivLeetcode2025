class NumArray {
    int [] prefix; 
    public NumArray(int[] nums) {
        this.prefix = new int [nums.length];
        int sum = 0 ;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefix[i] = sum; 
        }
    }
    
    public int sumRange(int left, int right) {
        int leftSum = left == 0 ? 0 : prefix[left - 1];
        int rightSum = prefix[right];
        return rightSum - leftSum; 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */