class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> mergedAccounts = new ArrayList<>();
        Map<String, String> nameMap = new HashMap<>();
        DSU dsu = new DSU(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            nameMap.put(accounts.get(i).get(1), accounts.get(i).get(0));
        }
        for (int i = 0; i < accounts.size(); i++) {
            String emailOne = accounts.get(i).get(1);
            dsu.find(emailOne);
            for (int j = 2; j < accounts.get(i).size(); j++) {
                String emailTwo = accounts.get(i).get(j);
                dsu.union(emailOne, emailTwo);
            }
        }
        
        HashMap<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for(int j = 1; j < accounts.get(i).size(); j++){ 
                String email = accounts.get(i).get(j);
                String key = dsu.find(email);
                Set<String> keyList = map.getOrDefault(key, new TreeSet<>());
                keyList.add(email);
                map.put(key, keyList);
            }

        }
        int index = 0;
        for(String key : map.keySet()){ 
            mergedAccounts.add(new ArrayList<>());
            mergedAccounts.get(index).add(nameMap.get(key));
            Set<String> allEmails = map.get(key);
            mergedAccounts.get(index).addAll(map.get(key));
           
            index++;
        }

    return mergedAccounts ;}
}
class DSU {
    Map<String, String> parentMap;

    public DSU(int size) {
        this.parentMap = new HashMap<>();
    }

    public String find(String email) {
        if (!parentMap.containsKey(email) || parentMap.get(email).equals(email)) {
            parentMap.put(email, email);
            return email;
        }
        parentMap.put(email, find(parentMap.get(email)));
        return parentMap.get(email);
    }

    public List<String> getParents() {
        List<String> parentList = new ArrayList<>();
        for (String key : parentMap.keySet()) {
            if (key.equals(parentMap.get(key))) {
                parentList.add(key);
            }
        }
        return parentList;
    }

    public void union(String a, String b) {
        String parentA = find(a);
        String parentB = find(b);
        if (parentA == parentB) {
            return;
        }
        parentMap.put(parentB, parentA);
    }
}
