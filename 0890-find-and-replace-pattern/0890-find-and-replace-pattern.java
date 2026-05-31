class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        String patternEncode = encode(pattern);
        for (int i = 0; i < words.length; i++) {
            if (patternEncode.equals(encode(words[i]))) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public String encode(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            // replace charater with the first index of the charater 
            charMap.putIfAbsent(s.charAt(i), i);
            sb.append(charMap.get(s.charAt(i))).append(":");
        }
        return sb.toString();
    }
}