class LRUCache {
    Node head;
    Node tail; 
    Map<Integer, Node> map; 
    int capacity;
    public LRUCache(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("Capacity is illegal");
        }
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key); 
        if(node == null){
            return -1;
        }
        onKeyAccessed(node); 
        return node.val;
    }
    public void put(int key, int val) {
        Node node = map.get(key); 
        if(node != null){
            node.val = val; 
            onKeyAccessed(node); 
            return;
        }
        if(capacity == map.size()){ 
            evicit();
        }
        node = new Node(key, val); 
        map.put(key, node); 
        addToFront(node);
    }
    private void onKeyAccessed(Node node){
        remove(node); 
        addToFront(node); 
    }
    private void addToFront(Node node){
        if(head == null){
            head = node; 
            tail = node; 
            return; 
        }
        node.prev = null; 
        head.prev = node; 
        node.next = head; 
        head = node;
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
    private void evicit(){ 
        Node victim = tail; 
        if(victim != null){ 
            remove(victim);
            map.remove(victim.key);
        }
    }
}
class Node{
    int val; 
    int key; 
    Node next; 
    Node prev;
    public Node(int key, int val){
        this.key = key; 
        this.val = val; 
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */