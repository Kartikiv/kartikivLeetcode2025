class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }
        onKeyAccessed(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            onKeyAccessed(key);
            return;
        }
        if (capacity == map.size()) {
            evict();
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addFirst(node);
    }

    private void onKeyAccessed(int key) {
        Node node = map.get(key);
        remove(key);
        addFirst(node);

    }

    private void evict() {
        if (tail != null) {
            int victim = tail.key;
            remove(tail.key);
            map.remove(victim);
        }
    }

    private void addFirst(Node node) {
        node.prev = null;
        node.next = head;
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        head.prev = node;
        head = node;
    }

    private void remove(int key) {
        Node node = map.get(key);
        if (node == null) {
            return;
        }
        Node nodePrev = node.prev;
        Node nodeNext = node.next;
        if (nodePrev != null) {
            nodePrev.next = nodeNext;
        } else {
            head = nodeNext;
        }
        if (nodeNext != null) {
            nodeNext.prev = nodePrev;
        } else {
            tail = nodePrev;
        }
        node.prev = null;
        node.next = null;

    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */