class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);

                emailToName.put(email, name);
                dsu.union(firstEmail, email);
            }
        }

        Map<String, List<String>> groups = new HashMap<>();

        for (String email : emailToName.keySet()) {
            String root = dsu.find(email);

            groups.computeIfAbsent(root, k -> new ArrayList<>())
                  .add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);

            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(entry.getKey()));
            merged.addAll(emails);

            result.add(merged);
        }

        return result;
    }
}

class DSU {
    Map<String, String> parent = new HashMap<>();
    Map<String, Integer> rank = new HashMap<>();

    String find(String x) {
        parent.putIfAbsent(x, x);
        rank.putIfAbsent(x, 0);

        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }

        return parent.get(x);
    }

    void union(String a, String b) {
        String rootA = find(a);
        String rootB = find(b);

        if (rootA.equals(rootB)) return;

        int rankA = rank.get(rootA);
        int rankB = rank.get(rootB);

        if (rankA > rankB) {
            parent.put(rootB, rootA);
        } else if (rankA < rankB) {
            parent.put(rootA, rootB);
        } else {
            parent.put(rootB, rootA);
            rank.put(rootA, rankA + 1);
        }
    }
}