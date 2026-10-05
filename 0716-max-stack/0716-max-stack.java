class Node {
    int val;
    Node next;
    Node prev;
}

class MaxStack {
    TreeMap<Integer, List<Node>> map;
    Node head;

    public MaxStack() {
        this.map = new TreeMap<>();
    }

    public void push(int x) {
        Node node;
        // check head 
        if (head == null) {
            node = new Node();
            node.val = x;
            head = node;
        } else {
            node = new Node();
            node.val = x;
            node.next = head;
            head.prev = node;
            head = node;
        }
        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(node);
    }

    public int pop() {
        Node node = head;
        if (node == null)
            return -1;
        head = node.next;
        if (head != null) {
            head.prev = null;
        }

        List<Node> nodeList = map.get(node.val);
        if (nodeList.size() == 1) {
            map.remove(node.val);
        } else {
            nodeList.remove(nodeList.size() - 1);
        }

        return node.val;
    }

    public int top() {
        Node node = head;
        if (node == null)
            return -1;

        return head.val;
    }

    public int peekMax() {
        if (map.isEmpty()) {
            return -1;
        }
        return map.lastKey();
    }

    public int popMax() {
        List<Node> nodeList = map.get(map.lastKey());
        Node node = nodeList.get(nodeList.size() - 1);
        nodeList.remove(nodeList.size() - 1);
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null) {
            prev.next = next;

        }
        if (next != null) {
            next.prev = prev;
        }
        if (node == head) {
            head = next;
        }
        if(nodeList.size() == 0){ 
            map.remove(node.val);
        }

        return node.val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */