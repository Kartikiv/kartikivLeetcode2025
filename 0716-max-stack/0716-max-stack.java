import java.util.*;

class MaxStack {

    private static class ListNode<T> {
        T val;
        ListNode<T> prev;
        ListNode<T> next;

        ListNode(T val) {
            this.val = val;
        }
    }

    private ListNode<Integer> tail;
    private TreeMap<Integer, List<ListNode<Integer>>> map;

    public MaxStack() {
        this.tail = null;
        this.map = new TreeMap<>();
    }

    public void push(int x) {
        ListNode<Integer> node = new ListNode<>(x);

        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        map.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
    }

    public int pop() {
        ListNode<Integer> node = tail;
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        }

        List<ListNode<Integer>> list = map.get(node.val);
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(node.val);
        }

        return node.val;
    }

    public int top() {
        return tail.val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = map.lastKey();
        List<ListNode<Integer>> list = map.get(max);

        ListNode<Integer> node = list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(max);
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == tail) {
            tail = node.prev;
        }

        return node.val;
    }
}