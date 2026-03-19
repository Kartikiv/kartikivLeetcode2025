
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
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        int min = minStack.isEmpty() ? val : Math.min(minStack.peek(), val);
        minStack.push(min);
    }
    
    public void pop() {
        if(stack.isEmpty()) return; 
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        if(stack.isEmpty()) return Integer.MAX_VALUE; 
        return stack.peek();
    }
    
    public int getMin() {
        if(stack.isEmpty()) return Integer.MAX_VALUE; 
        return minStack.peek();
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