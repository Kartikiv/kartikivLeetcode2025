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
    // loads the capacity and map
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
    /* 
    1. if the cache contains the key then we simply update the node at make it the head
    2. else if the head and tail are null put the key and the node in the map then make and head and tail point to the current node
    3. else make the current node as head and put the key and created node in the map
    4. if capacity < map.size we evict the tail node when evicing the tail if tail.prev is null that means the tail node is also the head node so we make the tail node as our head else we make our tail node as tail.prev 
    4. since we made our tails as tail.prev, the new tail.next is made null
     */

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            insertAtHead(node);
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
           
            if(map.size() > capacity ){
            map.remove(tail.key);    
            tail = (tail.prev != null)? tail.prev : head;
            tail.next = null;
          
            }
        }

    }
    /*
    1. If node is the head and tail we do nothing also if the node is head we do nothing 
    2. if the node is a tail node then we make the tail node the head and the node before the previous tail the new tail
    3. if node is neither the head nor the tail we connect the node.prev and node.next as adjactent nodes and make the node as head 
     */
    
    void insertAtHead(Node node) {
        if (node != head && node != tail) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            
            node.prev = null;
            node.next = head;
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