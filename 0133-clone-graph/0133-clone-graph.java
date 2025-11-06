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
            Node queueNode = queue.poll();

            for (Node neighborNode : queueNode.neighbors){
                if(!map.containsKey(neighborNode.val)){
                    map.put(neighborNode.val, new Node(neighborNode.val));
                    queue.add(neighborNode);
                }
                map.get(queueNode.val).neighbors.add(map.get(neighborNode.val));
            }

        }
        return ans; 
    }
}