/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        this.map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node ans = new Node(node.val);
        map.put(node.val, ans);
        queue.add(node);
        while(!queue.isEmpty()){
            Node queuNode = queue.poll();

            for (Node neighbNode : queuNode.neighbors){
                if(!map.containsKey(neighbNode.val)){
                    map.put(neighbNode.val, new Node(neighbNode.val));
                    queue.add(neighbNode);
                }
                map.get(queuNode.val).neighbors.add(map.get(neighbNode.val));
            }

        }
        return ans; 
    }
}