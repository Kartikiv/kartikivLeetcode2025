
import java.util.*;

class MovingAverage {
    Deque<Integer> deque; 
    int size;
    double sum;
    public MovingAverage(int size) {
        this.size = size;
        this.deque = new LinkedList<>();
        this.sum = 0 ;
    }
    
    public double next(int val) {
        if(deque.size() < size){
            deque.add(val);
            sum += val;
        }else{
            int firstElement = deque.pollFirst();
            sum -= firstElement;
            deque.add(val);
            sum += val;
        }
    return sum / deque.size();}
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */