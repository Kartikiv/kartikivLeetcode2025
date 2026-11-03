class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
       
        List<List<Integer>> ans = new ArrayList<>();
         if(nums.length == 0){
             List<Integer> temp = new ArrayList<>();
              temp.add(lower);
               temp.add(upper);
               ans.add(temp);
               return ans;

        }
        int i=0;
         if(nums[i]> lower){
         List<Integer> temp = new ArrayList<>();
            temp.add(lower);
            temp.add(nums[i]-1);
            ans.add(temp);
         }
       for( i =0 ; i<nums.length-1 ; i++){
        List<Integer> temp = new ArrayList<>();
       
        if(nums[i]+1 != nums[i+1]){
            temp.add(nums[i]+1);
            temp.add(nums[i+1]-1);
            ans.add(temp);
        }
     }
      if(nums[i]<upper){
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[i]+1);
            temp.add(upper);
            ans.add(temp);
       }
    return ans;}
}