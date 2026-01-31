
import java.util.Stack;
class StackNode{
    int index;
    int val;
    public StackNode(int index, int val) {
        this.index = index;
        this.val = val;
    } 
    
}
/**
 * Finds the number of days until a warmer temperature for each day.
 * 
 * Given an array of daily temperatures, this solution returns an array where
 * each element represents the number of days to wait until a warmer temperature
 * is observed. If no warmer temperature exists in the future, the value is 0.
 * 
 * Time Complexity: O(n) - Each element is pushed and popped from the stack at most once.
 * Space Complexity: O(n) - Stack can contain at most n elements in worst case.
 * 
 * @param temperatures an array of integers representing daily temperatures
 * @return an array where each element at index i represents the number of days
 *         until a warmer temperature is found after day i, or 0 if no such day exists
 * 
 * Example:
 *     Input: temperatures = [73,74,75,71,69,72,76,73]
 *     Output: [1,1,4,2,1,1,0,0]
 */
class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<StackNode> stack = new Stack<>();
        int [] ans = new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length; i++){
            int temperature  = temperatures[i];
            while(!stack.isEmpty() && stack.peek().val < temperature ){
                StackNode node = stack.pop();
                ans[node.index] = i - node.index;
            }
            stack.add(new StackNode(i, temperature));
        }
   return ans; }
}