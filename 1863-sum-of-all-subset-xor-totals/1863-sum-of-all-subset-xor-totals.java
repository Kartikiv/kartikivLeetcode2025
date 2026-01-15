class Solution {
    int ans = 0 ;
    int [] nums;
    public int subsetXORSum(int[] nums) {
        this.nums = nums;
     dfs(0, 0);

      return ans;
    }
    public void dfs (int i, int xor){
        if( i > nums.length - 1 ){
            ans += xor;
            return;
        } 

        dfs(i + 1, xor ^ nums[i]);
        dfs(i + 1, xor);


    }



    public int xorArr(int nums[]){
         int ans = 0 ;

        for(int num : nums){
            ans ^= num;
        }
        
    return ans;
    }
    }