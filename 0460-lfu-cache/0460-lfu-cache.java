
import java.util.*;

class Node {
    int key, val, freq;
    long timestamp;
    boolean isDeleted;

    Node(int key, int val, int freq, long timestamp) {
        this.key = key;
        this.val = val;
        this.freq = freq;
        this.timestamp = timestamp;
    }
}

class LFUCache {
    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final PriorityQueue<Node> pq;

    private long clock = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;

        pq = new PriorityQueue<>((a, b) -> {
            int cmp = Integer.compare(a.freq, b.freq);
            return cmp != 0
                ? cmp
                : Long.compare(a.timestamp, b.timestamp);
        });
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        update(node, node.val);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        Node node = map.get(key);

        if (node != null) {
            update(node, value);
            return;
        }

        if (map.size() == capacity) {
            evict();
        }

        Node newNode = new Node(key, value, 1, ++clock);
        map.put(key, newNode);
        pq.offer(newNode);
    }

    private void update(Node oldNode, int value) {
        oldNode.isDeleted = true;

        Node newNode = new Node(
            oldNode.key,
            value,
            oldNode.freq + 1,
            ++clock
        );

        map.put(newNode.key, newNode);
        pq.offer(newNode);
    }

    private void evict() {
        cleanUp();

        if (!pq.isEmpty()) {
            Node victim = pq.poll();
            map.remove(victim.key);
        }
    }

    private void cleanUp() {
        while (!pq.isEmpty() && pq.peek().isDeleted) {
            pq.poll();
        }
    }
}
