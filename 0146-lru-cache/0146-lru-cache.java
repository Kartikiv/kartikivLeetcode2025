class Node {
    int key, value;
    Node next, prev;

    Node(int k, int v, Node n, Node p) {
        this.key = k;
        this.value = v;
        this.next = n;
        this.prev = p;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

    }

    /*
    1. If key is in cache return last updated value else -1
    2. make the key accesed as head 
       1. if key is the head just return key do nothing
       2. if key is tail make the prev of tail as tail and make the tail as head 
       3. else if key is a between node make key head and connect the rest of the list 
      */
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            insertAtHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            get(key);
            map.get(key).value = value;
        } else {
            Node node = new Node(key, value, head, null);
            if (head == null && tail == null) {
                head = node;
                tail = node;
                map.put(key, node);
                return;
            }
            head.prev = node;
            head = node;
            map.put(key, node);
            if(capacity == 1){
                map.remove(tail.key);    
                head = node;
                tail = node;
                return ; 
            }
            if(map.size() > capacity){
            map.remove(tail.key);    
            tail = tail.prev;
            tail.next = null;
          
            }
        }

    }

    void insertAtHead(Node node) {
        if (node != head && node != tail) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        } else if (node != head && node == tail) {
            node.prev.next = null;
            tail = node.prev;
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */