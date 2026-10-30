class Node { 
    Node prev; 
    Node next; 
    int val; 
    int key; 
    public Node(int key, int val){ 
        this.key = key; 
        this.val = val; 
    }
}
class LRUCache {
    Node head; 
    Node tail; 
    Map<Integer, Node> map; 
    int capacity;
    public LRUCache(int capacity) {
        if(capacity <= 0){ 
            throw new IllegalArgumentException();
        }
        this.capacity = capacity; 
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        onKeyAccessed(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        
        Node node = map.get(key); 
        if(node!= null){ 
            node.val = value;
            onKeyAccessed(node);
            return;
        }
        if(map.size() == capacity){
            evict();
        }
        node = new Node(key, value);
        addToFront(node);
        map.put(key, node);
    }
    private void addToFront(Node node){ 
        if(head == null){ 
            head = node; 
            tail = node; 
            return ; 
        }
        node.prev = null; 
        node.next = head; 
        head.prev = node; 
        head = node;
    }
    private void onKeyAccessed(Node node){ 
        remove(node);
        addToFront(node);
    }
    private void evict(){ 
        if(tail != null){
            map.remove(tail.key); 
            remove(tail);
        }
    }
    private void remove(Node node){ 
        if(node.prev != null){ 
            node.prev.next = node.next; 
        }else{ 
            head = node.next;
        }

        if(node.next != null){ 
            node.next.prev = node.prev; 
        }else{ 
            tail = node.prev;
        }
        node.next = null; 
        node.prev = null;
    }
     
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */