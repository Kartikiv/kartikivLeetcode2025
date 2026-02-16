
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    int limit;
    Deque<Integer> maxDeque;
    Deque<Integer> minDeque;
    int[] nums;

    public int longestSubarray(int[] nums, int limit) {
        this.maxDeque = new LinkedList<>();
        this.minDeque = new LinkedList<>();
        this.nums = nums;
        this.limit = limit;
        int maxLen = 0;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            findMax(j);
            findMin(j);
            while (!isValid()) {
                if (maxDeque.peekFirst() == i) maxDeque.pollFirst();
                if (minDeque.peekFirst() == i) minDeque.pollFirst();
                i++;

            }
            maxLen = Math.max(j - i + 1, maxLen);

        }

   return maxLen; 
 }

    private int findMax(int j) {
        while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[j])
            maxDeque.pollLast();
        maxDeque.offerLast(j);

        return maxDeque.peek();
    }

    private int findMin(int j) {
        while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[j])
            minDeque.pollLast();
        minDeque.offerLast(j);
    return minDeque.peek(); 
}

    private boolean isValid() {

    return nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] <= limit; 
}
}