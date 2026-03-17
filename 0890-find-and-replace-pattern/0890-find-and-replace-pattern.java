class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            if (word.length() != pattern.length()) continue;

            int[] wordMap = new int[26];
            int[] patternMap = new int[26];
            boolean match = true;

            for (int i = 0; i < word.length(); i++) {
                int w = word.charAt(i) - 'a';
                int p = pattern.charAt(i) - 'a';

                if (wordMap[w] == 0) wordMap[w] = i + 1;
                if (patternMap[p] == 0) patternMap[p] = i + 1;

                if (wordMap[w] != patternMap[p]) {
                    match = false;
                    break;
                }
            }

            if (match) ans.add(word);
        }

        return ans;
    }
}