class StackNode {
    int value; 
    int minValue; 
    public StackNode(int value, int minValue){
        this.value = value;
        this.minValue = minValue;
    }
}
class MinStack {
    Stack<StackNode> stack;
    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if ( stack.isEmpty()){
            stack.add(new StackNode(val, val));
        }
        else{
            int minVal = stack.peek().minValue;
            if (minVal > val){
                minVal = val;
            }
            stack.add(new StackNode(val, minVal));
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.isEmpty()? null :stack.peek().value;
    }
    
    public int getMin() {
        return stack.isEmpty()? null :stack.peek().minValue;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();

1. On way to solve the problem is use a priority queue and stack but it will be O(nlogn) not optimal
 2. We need have all operation in O(1) so we will create a stack in that stack everyNode will have a value and min till it was added
 3. This way getting the min will be reduced to O(1)
 4. 
 */