import java.util.*;

class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
    List<Integer> list = new ArrayList<>();
    boolean used[] = new boolean[nums.length];
    dfs(nums,used,list);


    return  new ArrayList(ans);
    }
     void dfs(int [] nums , boolean [] used, List<Integer> list){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(!used[i]){
                list.add(nums[i]);
                used[i] = true;
                dfs(nums, used,list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}