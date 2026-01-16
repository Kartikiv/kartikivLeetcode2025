import java.util.*;
class KthLargest {
    int k ;
    PriorityQueue<Integer> pq ;
    public KthLargest(int k, int[] nums) {
        this.k =k;
        this.pq = new PriorityQueue<>();
        for(int num : nums){
           add(num); 
        }
    }
    
    public int add(int val) {

        pq.add(val);

        while(pq.size() > k){
            pq.poll();
        }
        
   return pq.peek();
 }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */