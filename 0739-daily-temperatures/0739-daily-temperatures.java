import java.util.*;
class StackNode{
    int val; 
    int index; 
    public StackNode (int val,int index){
        this.val = val; 
        this.index = index;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<StackNode> stack = new Stack<>(); 
        int [] res = new int [temperatures.length]; 
        for (int i = 0; i < temperatures.length; i++) {
            if(stack.isEmpty()){
                stack.add(new StackNode(temperatures[i], i));
            }
            else{
                while(!stack.isEmpty() && stack.peek().val < temperatures[i]){
                   StackNode node = stack.pop();
                   res[node.index] = i - node.index;
                }
                stack.add(new StackNode(temperatures[i], i));
            }
        } 
    return res ;
}
}