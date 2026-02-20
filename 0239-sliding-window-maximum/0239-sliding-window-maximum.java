// One idea is tro implement a priority queue of the length of the window 
// next we add and remove elements vise versa 
// this make the implemenmtation effecient 
// here deletion from the pq is the main issue it O n 
// so algo is o (n . k) worst case
// marked for revisit need to learn monotonic queue
/*  
1. one way to inmplenet a monotonic stack might be in the window we will add all elements in the increasing order as 
win 1 : [1, 3 ]
win 2 : []
 */
import java.util.*;
 class QueueNode{
    int val; 
    int index;
    public QueueNode(int val, int index){
        this.val = val;
        this.index = index;
    }
    public String toString(){
        return this.val + " " + this.index;
    }
 }
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    Deque <QueueNode> windowQueue = new LinkedList<>();
    int ans[] = new int [nums.length - k + 1];    
    int l =0 ; 
    int r = 0;
    for(; r < k ; r++){
        while(!windowQueue.isEmpty() &&windowQueue.peekLast().val < nums[r]){
            windowQueue.pollLast();
        }
        windowQueue.add(new QueueNode(nums[r], r));
    }
    while (r < nums.length) {
        QueueNode node = windowQueue.peekFirst();
        ans[l] = node.val;
        l++;
        while (!windowQueue.isEmpty() && node.index < l){
            windowQueue.pollFirst();
            node = windowQueue.peekFirst();
        }
         while(!windowQueue.isEmpty() &&windowQueue.peekLast().val < nums[r]){
            windowQueue.pollLast();
        }
        windowQueue.add(new QueueNode(nums[r], r));

        r++;
        }
        ans[l] = windowQueue.pollFirst().val;
 return ans ;   
 }
}