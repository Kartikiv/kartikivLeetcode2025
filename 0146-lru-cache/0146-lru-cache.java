
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class LRUCache {
    private static class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final ConcurrentHashMap<Integer, Node> map;
    private final ReentrantLock lock = new ReentrantLock();

    private Node head, tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>();
    }

    public int get(int key) {
        lock.lock();
        try {
            Node node = map.get(key);
            if (node == null) return -1;

            moveToFront(node);
            return node.val;
        } finally {
            lock.unlock();
        }
    }

    public void put(int key, int value) {
        lock.lock();
        try {
            Node node = map.get(key);

            if (node != null) {
                node.val = value;
                moveToFront(node);
                return;
            }

            if (map.size() == capacity) {
                evict();
            }

            node = new Node(key, value);
            addToFront(node);
            map.put(key, node);
        } finally {
            lock.unlock();
        }
    }

    private void moveToFront(Node node) {
        if (node == head) return;
        remove(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        node.prev = null;
        node.next = head;

        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }

        head = node;
    }

    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        node.prev = null;
        node.next = null;
    }

    private void evict() {
        if (tail == null) return;

        Node victim = tail;
        remove(victim);
        map.remove(victim.key);
    }
}
