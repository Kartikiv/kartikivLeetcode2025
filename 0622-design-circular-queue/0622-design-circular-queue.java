class Node{
    int val;
    Node next;
    Node prev;
    public Node ( int val){
        this.val = val;
    }

}
// This All the operations are O(1)
public class MyCircularQueue {
    Node head;
    Node tail;
    int size;
    int maxSize;


    public MyCircularQueue(int k) {
        this.maxSize = k;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
   // Operational Cost is  O (1)
    public boolean enQueue(int value) {
        if  (size >= maxSize) { return false; }
        Node node = new Node(value);
        if(size == 0){
            head = node;
            tail = node;
            size++;
            return true;
        } 
        tail.next = node;
        node.prev = tail;
        node.next = head;
        tail = node;
        size++;

        return true;}

    public boolean deQueue() {
        if(size == 0 ) return false;
        if(head == tail ) {
            head = null;
            tail = null;
            size--;
            return true;
        }
        head = head.next;
        head.prev = tail;
        size--;
        
    return true;}

    public int Front() {
        if(size == 0 ) return -1;
        return head.val;
    }

    public int Rear() {
        if(size == 0 ) return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return  size == maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */