class Solution {
    // The String Should be isomorphic to group all the string we get the signature and from that move to map them
    public List<List<String>> groupStrings(String[] strings) {
        Map<String , List<String>> map = new HashMap<>(); 
        for(String s : strings){
            String key = getSignature(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

    return map.values().stream().toList(); 
    }
   String getSignature(String s) {
        StringBuilder sb = new StringBuilder();
        int offset = s.charAt(0) - 'a';

        for (char c : s.toCharArray()) {
            int shifted = (c - 'a' - offset + 26) % 26;
            sb.append((char) ('a' + shifted));
        }

        return sb.toString();
    }
}