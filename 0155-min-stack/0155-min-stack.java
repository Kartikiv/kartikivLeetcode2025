
import java.util.Stack;

class StackNode{
    int val; 
    int min; 
    public StackNode(int val, int min){
        this.val = val;
        this.min = min;
    }
}
class MinStack {
    Stack<StackNode> stack;
    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
        stack.push(new StackNode(val, val));
        }else{
            stack.push(new StackNode(val, Math.min(val, stack.peek().min)));
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return; 
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return Integer.MAX_VALUE; 
        return stack.peek().val;
    }
    
    public int getMin() {
        if(stack.isEmpty()) return Integer.MAX_VALUE; 
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */