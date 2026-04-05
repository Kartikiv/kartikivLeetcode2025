import java.util.*;

class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

class MaxStack {
    ListNode tail;
    TreeMap<Integer, List<ListNode>> map;

    public MaxStack() {
        this.map = new TreeMap<>();
        this.tail = null;
    }

    public void push(int x) {
        ListNode newNode = new ListNode(x);

        if (tail == null) {
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        map.computeIfAbsent(x, k -> new ArrayList<>()).add(newNode);
    }

    public int pop() {
        if (tail == null) {
            return Integer.MIN_VALUE;
        }

        ListNode removedNode = tail;
        tail = tail.prev;

        if (tail != null) {
            tail.next = null;
        }

        List<ListNode> list = map.get(removedNode.val);
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            map.remove(removedNode.val);
        }

        return removedNode.val;
    }

    public int top() {
        if (tail == null) {
            return Integer.MIN_VALUE;
        }
        return tail.val;
    }

    public int peekMax() {
        if (map.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return map.lastKey();
    }

    public int popMax() {
        if (map.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int max = map.lastKey();
        List<ListNode> list = map.get(max);
        ListNode maxNode = list.remove(list.size() - 1);

        if (list.isEmpty()) {
            map.remove(max);
        }

        if (maxNode.prev != null) {
            maxNode.prev.next = maxNode.next;
        }

        if (maxNode.next != null) {
            maxNode.next.prev = maxNode.prev;
        }

        if (maxNode == tail) {
            tail = maxNode.prev;
        }

        return maxNode.val;
    }
}