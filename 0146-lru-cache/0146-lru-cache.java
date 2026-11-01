import java.util.*;

class LRUCache {
    private final List<Map<Integer, Node>> shards;
    private final int capacity;
    private Node head, tail;
    private int size;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }

        this.capacity = capacity;
        int shardCount = Math.min(capacity, 4);

        shards = new ArrayList<>(shardCount);
        for (int i = 0; i < shardCount; i++) {
            shards.add(new HashMap<>());
        }
    }

    private Map<Integer, Node> shard(int key) {
        return shards.get(Math.floorMod(key, shards.size()));
    }

    public synchronized int get(int key) {
        Node node = shard(key).get(key);
        if (node == null) return -1;

        moveToFront(node);
        return node.val;
    }

    public synchronized void put(int key, int value) {
        Map<Integer, Node> map = shard(key);
        Node node = map.get(key);

        if (node != null) {
            node.val = value;
            moveToFront(node);
            return;
        }

        if (size == capacity) {
            Node victim = tail;
            remove(victim);
            shard(victim.key).remove(victim.key);
            size--;
        }

        node = new Node(key, value);
        map.put(key, node);
        addToFront(node);
        size++;
    }

    private void moveToFront(Node node) {
        remove(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        node.prev = null;
        node.next = head;

        if (head != null) head.prev = node;
        else tail = node;

        head = node;
    }

    private void remove(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        node.prev = null;
        node.next = null;
    }
}

class Node {
    int key, val;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}