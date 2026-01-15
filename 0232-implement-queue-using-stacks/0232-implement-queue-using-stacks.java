
import java.util.*;

class MyQueue {
 Queue<Integer> queue;
    public MyQueue() {
       this.queue = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue<Integer> tempQueue = new LinkedList<>();
        while(!queue.isEmpty()){
            tempQueue.add(queue.poll());
        }
        tempQueue.add(x);
        while(!tempQueue.isEmpty()){
            queue.add(tempQueue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int peek() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */