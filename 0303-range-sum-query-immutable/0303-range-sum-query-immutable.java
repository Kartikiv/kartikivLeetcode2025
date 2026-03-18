class NumArray {
    int [] prefix; 
    public NumArray(int[] nums) {
        this.prefix = new int [nums.length + 1];
        int sum = 0 ;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefix[i + 1] = sum; 
        }
    }
    
    public int sumRange(int left, int right) {
        int leftSum = prefix[left];
        int rightSum = prefix[right + 1];
        return rightSum - leftSum; 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */