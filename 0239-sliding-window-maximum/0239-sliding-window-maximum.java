
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int [] ans = new int [nums.length - k + 1];
        int ansIndex= 0;
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < k ; i++){
            while(!queue.isEmpty() &&queue.peekLast() < nums[i]){
                queue.pollLast();
            }
            queue.add(nums[i]);
        }
        int left = 0 ;
        ans[ansIndex++] = queue.peekFirst();

        for(int right = k ; right < nums.length; right++){
            // check if the curennt removed element is the first in queue
            if(queue.peekFirst() == nums[left++]) queue.pollFirst();
            while(!queue.isEmpty() &&queue.peekLast() < nums[right]){
                queue.pollLast();
            }
            queue.add(nums[right]);
            ans[ansIndex++] = queue.peekFirst();
        }
    return ans;}
}