import java.util.*;

class StackNode {
    @Override
    public String toString() {
        return "StackNode [index=" + index + ", val=" + val + "]";
    }

    int index;
    int val;

    public StackNode(int index, int val) {
        this.index = index;
        this.val = val;
    }
}

/**
 * Finds the next greater element for each element in a circular array.
 * 
 * For each element in the input array, this method finds the first element
 * to its right that is greater than the current element. Since the array is
 * treated as circular, after the last element, the search continues from
 * the first element.
 * 
 * @param nums an array of integers in which to find next greater elements
 * @return an array where each element at index i contains the next greater
 *         element for nums[i], or -1 if no greater element exists in the
 *         circular array
 * 
 * Time Complexity: O(n) where n is the length of the input array.
 *                  Each element is pushed and popped from the stack at most once.
 * Space Complexity: O(n) for the stack and output array in the worst case.
 * 
 * @see StackNode
 */
class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<StackNode> stack = new Stack<>();
        for (int i = 0; i < 2 * nums.length; i++) {
            int index = i % nums.length;
            int num = nums[index];
            while (!stack.isEmpty() && stack.peek().val < nums[index]) {
                StackNode node = stack.pop();
                ans[node.index] = num;
            }
            stack.add(new StackNode(index, num));

        }
        
        return ans;
    }
}