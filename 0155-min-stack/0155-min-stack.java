import java.util.Stack;

class MinStack {
    
    Stack<Long> stack;
    long min; 

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
       if(stack.isEmpty()){
        stack.push(0L);
        min = val;
       }else{
        long diff = (long) val - min;
        stack.push(diff);
        if(val < min){
            min = val;
        }
       }
    }
    
    public void pop() {
        if(stack.isEmpty()) return; 

        long diff = stack.pop();

        if(diff < 0){
            min = min - diff;
        }
    }
    
    public int top() {
        if(stack.isEmpty()) return Integer.MAX_VALUE; 

        long diff = stack.peek();

        if(diff >= 0){
            return (int)(min + diff);
        } else {
            return (int)min;
        }
    }
    
    public int getMin() {
        if(stack.isEmpty()) return Integer.MAX_VALUE; 
        return (int)min;
    }
}