class Node {
    int val;
    Node next;
    Node prev;
    boolean isDeleted;
    int id;

    public Node(int val) {
        this.val = val;
    }
}

class MaxStack {
    int id = 0;
    Node head;
    PriorityQueue<Node> pq;

    public MaxStack() {
        this.pq = new PriorityQueue<>((a, b) -> {
            if(Integer.compare(b.val, a.val) == 0){ 
                return Integer.compare(b.id, a.id);
            }
            return Integer.compare(b.val, a.val);
        });
          
    }

    public void push(int x) {
        // If head is null -> create a node and return
        // if not create a node make it the head 
        Node node = new Node(x);
        node.id = id++;
        pq.add(node);
        if (head == null) {
            head = node;
            return;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

    public int pop() {
        Node node = head;
        if (node == null) {
            return -1;
        } else {
            Node next = head.next;
            node.next = null;
            if (next != null) {
                next.prev = null;
            }
            node.isDeleted = true;
            head = next;
            // we marked the node deleted , we replace the connected and assigned the new head
        }
        return node.val;
    }

    public int top() {
        if(head == null){ 
            return -1;
        }
        return head.val;
    }

    public int peekMax() {
        cleanUp();
        return pq.isEmpty() ? -1 : pq.peek().val;
    }

    public int popMax() {
        cleanUp();
        if(pq.isEmpty()){
            return -1;
        }
        Node node = pq.poll();
        Node prev = node.prev;
        Node next = node.next; 
        if(prev != null){
            prev.next = next;
        }
        if(next != null){ 
             next.prev = prev;
        }
        // Gc to clear node 
        node.next = null;
        node.prev = null;
        if(node == head){
            head = next;
        }
        return node.val;
    }
    void cleanUp(){ 
        while(!pq.isEmpty() && pq.peek().isDeleted){
             pq.poll();
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */