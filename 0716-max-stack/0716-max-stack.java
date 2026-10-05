class Node {
    int val;
    long id;
    Node next;
    Node prev;
    boolean isDelete = false;

    public Node(int x,long id, Node prev, Node next) {
        this.val = x;
        this.id = id;
        this.prev = prev;
        this.next = next;
    }
}

class MaxStack {
    static long id;
    PriorityQueue<Node> pq;
    Node head;

    public MaxStack() {
         pq = new PriorityQueue<>((a, b) -> {
            if (a.val != b.val) {
                return Integer.compare(b.val, a.val);
            }

            // more recently pushed node first
            return Long.compare(b.id, a.id);
        });
    }

    public void push(int x) {
        
        if (head == null) {
            head = new Node(x, id++, null, null);
            pq.add(head);
        } else {
            Node node = new Node(x,id++, null, head);
            head.prev = node;
            head = node;
            pq.add(node);
        }
    }

    public int pop() {
        if (head == null)
            return -1;
        Node nodeRemoved = head;
        head = nodeRemoved.next;
        nodeRemoved.isDelete = true;
        if (head != null) {
            head.prev = null;
        }

        return nodeRemoved.val;
    }

    public int top() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    public int peekMax() {
        cleanup();
        if (pq.isEmpty()) {
            return -1;
        }
        return pq.peek().val;
    }

    public void cleanup() {
        while (!pq.isEmpty() && pq.peek().isDelete) {
        pq.poll();
    }
    }

    public int popMax() {
        cleanup();
        if (pq.isEmpty())
            return -1;
        Node node = pq.poll();
        Node prevNode = node.prev;
        Node nextNode = node.next;
        if(node == head){ 
            head = nextNode;
        }
        if (prevNode != null) {
            prevNode.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
       
        node.next = null;
        node.prev = null;
        node.isDelete = true;
        return node.val;
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