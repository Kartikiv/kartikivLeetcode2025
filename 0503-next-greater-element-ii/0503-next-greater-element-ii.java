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