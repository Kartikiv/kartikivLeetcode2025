class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s+");
        char[] patternArr = pattern.toCharArray();
        if (words.length != patternArr.length) return false;

        Map<Object, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(patternArr[i], i);
            map.putIfAbsent(words[i], i);

            if (!map.get(patternArr[i]).equals(map.get(words[i]))) {
                return false;
            }
        }

        return true;
    }
}