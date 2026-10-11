class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        DSU dsu = new DSU(c);

        for (int[] connection : connections) {
            int u = connection[0] - 1;
            int v = connection[1] - 1;

            dsu.union(u, v);
        }

        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {

            int operation = query[0];
            int operand = query[1] - 1;

            // maintenance check
            if (operation == 1) {

                // machine itself is online
                if (dsu.onlineStatus[operand]) {
                    result.add(operand + 1);
                } else {

                    int root = dsu.find(operand);
                    TreeSet<Integer> set = dsu.map.get(root);

                    result.add(
                        set.isEmpty()
                            ? -1
                            : set.getFirst() + 1
                    );
                }
            }

            // machine goes offline
            else if (operation == 2) {

                if (!dsu.onlineStatus[operand]) {
                    continue;
                }

                dsu.onlineStatus[operand] = false;

                int root = dsu.find(operand);

                dsu.map.get(root).remove(operand);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

class DSU {

    int[] parent;
    int[] rank;

    boolean[] onlineStatus;

    HashMap<Integer, TreeSet<Integer>> map;

    public DSU(int size) {

        parent = new int[size];
        rank = new int[size];
        onlineStatus = new boolean[size];

        map = new HashMap<>();

        for (int i = 0; i < size; i++) {

            parent[i] = i;
            onlineStatus[i] = true;

            TreeSet<Integer> set = new TreeSet<>();
            set.add(i);

            map.put(i, set);
        }
    }

    public int find(int a) {

        if (parent[a] == a) {
            return a;
        }

        parent[a] = find(parent[a]);

        return parent[a];
    }

    public void union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return;
        }

        int parentNode;
        int childNode;

        if (rank[parentA] < rank[parentB]) {

            parent[parentA] = parentB;

            parentNode = parentB;
            childNode = parentA;

        } else if (rank[parentA] > rank[parentB]) {

            parent[parentB] = parentA;

            parentNode = parentA;
            childNode = parentB;

        } else {

            parent[parentB] = parentA;
            rank[parentA]++;

            parentNode = parentA;
            childNode = parentB;
        }

        TreeSet<Integer> parentQueue = map.get(parentNode);
        TreeSet<Integer> childQueue = map.get(childNode);

        parentQueue.addAll(childQueue);

        map.remove(childNode);
    }
}