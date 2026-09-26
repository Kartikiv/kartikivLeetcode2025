import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;

        Map<String, Integer> needed = new HashMap<>();

        for (String word : words) {
            needed.put(word, needed.getOrDefault(word, 0) + 1);
        }

        // We need to try every possible alignment.
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;

            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                // Completely invalid word
                if (!needed.containsKey(word)) {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                    continue;
                }

                // Add word to window
                window.put(word, window.getOrDefault(word, 0) + 1);
                count++;

                // Too many copies of this word
                while (window.get(word) > needed.get(word)) {

                    String leftWord =
                            s.substring(left, left + wordLen);

                    window.put(
                            leftWord,
                            window.get(leftWord) - 1
                    );

                    left += wordLen;
                    count--;
                }

                // Exact number of words
                if (count == wordCount) {

                    result.add(left);

                    // Move one word forward so overlapping
                    // matches can still be found.
                    String leftWord =
                            s.substring(left, left + wordLen);

                    window.put(
                            leftWord,
                            window.get(leftWord) - 1
                    );

                    left += wordLen;
                    count--;
                }
            }
        }

        return result;
    }
}