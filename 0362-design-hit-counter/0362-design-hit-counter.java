import java.util.*;

class HitCounter {
    Deque<Integer> queue;

    public HitCounter() {
        this.queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        while(!queue.isEmpty() && queue.peekFirst() < timestamp - 300){
            queue.pollFirst();
        }
        queue.addLast(timestamp);
      //  System.out.println(queue);
    }

    public int getHits(int timestamp) {
          while(!queue.isEmpty() && queue.peekFirst() <= timestamp - 300){
            queue.pollFirst();
        }
        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */