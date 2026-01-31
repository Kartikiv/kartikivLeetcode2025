
import java.util.Stack;
class StackNode{
    int index;
    int val;
    public StackNode(int index, int val) {
        this.index = index;
        this.val = val;
    } 
    
}
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