class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s : words){
            String key = getSignature(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        pattern = getSignature(pattern);
        List<String > ans = map.get(pattern);
        return ans == null ? new ArrayList<>() : ans;
    }

    String getSignature(String s) {
        int[] map = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 0) {
                map[s.charAt(i) - 'a'] = i + 1;
            }
            sb.append(map[s.charAt(i) - 'a']).append(":");
        }
        return sb.toString();
    }
}