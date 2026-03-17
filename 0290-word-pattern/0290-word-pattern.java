class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map mapIndex = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length()) return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            mapIndex.putIfAbsent(c, i);
            mapIndex.putIfAbsent(w, i);

            if (!mapIndex.get(c).equals(mapIndex.get(w))) {
                return false;
            }
        }

        return true;
    }
}