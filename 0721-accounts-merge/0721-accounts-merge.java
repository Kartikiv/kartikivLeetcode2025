import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> emailToId = new HashMap<>();
        List<String> idToEmail = new ArrayList<>();
        Map<String, String> emailToName = new HashMap<>();

        int id = 0;

        // 1. Assign each unique email an integer ID
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, id++);
                    idToEmail.add(email);
                }

                emailToName.put(email, name);
            }
        }

        // 2. Build DSU
        DSU dsu = new DSU(id);

        // 3. Union all emails belonging to the same account
        for (List<String> account : accounts) {
            int firstEmailId = emailToId.get(account.get(1));

            for (int i = 2; i < account.size(); i++) {
                int currentEmailId = emailToId.get(account.get(i));
                dsu.union(firstEmailId, currentEmailId);
            }
        }

        // 4. Group emails by DSU root
        Map<Integer, List<String>> groups = new HashMap<>();

        for (int emailId = 0; emailId < id; emailId++) {
            int root = dsu.find(emailId);

            groups
                .computeIfAbsent(root, k -> new ArrayList<>())
                .add(idToEmail.get(emailId));
        }

        // 5. Sort each group and build answer
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : groups.entrySet()) {

            List<String> emails = entry.getValue();
            Collections.sort(emails);

            String rootEmail = idToEmail.get(entry.getKey());
            String name = emailToName.get(rootEmail);

            List<String> mergedAccount = new ArrayList<>(emails.size() + 1);

            mergedAccount.add(name);
            mergedAccount.addAll(emails);

            result.add(mergedAccount);
        }

        return result;
    }
}


class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }

        return parent[a];
    }

    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return;
        }

        if (rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        } else if (rank[parentA] > rank[parentB]) {
            parent[parentB] = parentA;
        } else {
            parent[parentB] = parentA;
            rank[parentA]++;
        }
    }
}