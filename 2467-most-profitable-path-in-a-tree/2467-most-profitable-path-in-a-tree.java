
import java.util.*;

class Solution {

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;

        List<Integer>[] adjacencyList = new List[n];
        Arrays.setAll(adjacencyList, i -> new ArrayList<>());

        for (int[] edge : edges) {
            adjacencyList[edge[0]].add(edge[1]);
            adjacencyList[edge[1]].add(edge[0]);
        }

        // Step 1: Find Bob's path using DFS iterator
        Map<Integer, Integer> bobPath =
                findBobPath(bob, 0, adjacencyList);

        // Step 2: Find Alice's maximum profit
        return dfsAlice(
                0, -1, 0, adjacencyList, bobPath, amount
        );
    }

    private Map<Integer, Integer> findBobPath(
            int bob,
            int goal,
            List<Integer>[] graph) {

        DFSIterator iterator = new DFSIterator(graph, bob);

        if (bob != goal) {
            while (iterator.hasNext()) {
                int node = iterator.next();

                if (node == goal) {
                    break;
                }
            }
        }

        // Stack now contains Bob -> ... -> 0
        List<Integer> path = iterator.getPath();

        Map<Integer, Integer> bobPath = new HashMap<>();

        for (int i = 0; i < path.size(); i++) {
            bobPath.put(path.get(i), i);
        }

        return bobPath;
    }

    private int dfsAlice(
            int node,
            int parent,
            int time,
            List<Integer>[] graph,
            Map<Integer, Integer> bobPath,
            int[] amount) {

        int bobTime = bobPath.getOrDefault(
                node, Integer.MAX_VALUE
        );

        int profit;

        if (time < bobTime) {
            profit = amount[node];
        } else if (time == bobTime) {
            profit = amount[node] / 2;
        } else {
            profit = 0;
        }

        int maxChildProfit = Integer.MIN_VALUE;

        for (int neighbor : graph[node]) {
            if (neighbor == parent) {
                continue;
            }

            maxChildProfit = Math.max(
                    maxChildProfit,
                    dfsAlice(
                            neighbor,
                            node,
                            time + 1,
                            graph,
                            bobPath,
                            amount
                    )
            );
        }

        // Alice must stop at a leaf
        if (maxChildProfit == Integer.MIN_VALUE) {
            return profit;
        }

        return profit + maxChildProfit;
    }
}

class DFSIterator implements Iterator<Integer> {

    private final List<Integer>[] graph;
    private final Deque<Frame> stack;
    private final boolean[] visited;

    static class Frame {
        int node;
        int nextIndex;

        Frame(int node) {
            this.node = node;
            this.nextIndex = 0;
        }
    }

    public DFSIterator(List<Integer>[] graph, int start) {
        this.graph = graph;
        this.stack = new ArrayDeque<>();
        this.visited = new boolean[graph.length];

        stack.push(new Frame(start));
        visited[start] = true;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Frame top = stack.peek();

            // Look for an unexplored neighbor
            while (top.nextIndex < graph[top.node].size()) {
                int neighbor =
                        graph[top.node].get(top.nextIndex);

                if (!visited[neighbor]) {
                    return true;
                }

                top.nextIndex++;
            }

            // All neighbors explored: backtrack
            stack.pop();
        }

        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Frame top = stack.peek();

        int neighbor =
                graph[top.node].get(top.nextIndex++);

        visited[neighbor] = true;
        stack.push(new Frame(neighbor));

        return neighbor;
    }

    public List<Integer> getPath() {
        List<Integer> path = new ArrayList<>();

        // Descending iterator reads bottom -> top
        Iterator<Frame> iterator = stack.descendingIterator();

        while (iterator.hasNext()) {
            path.add(iterator.next().node);
        }

        return path;
    }
}
