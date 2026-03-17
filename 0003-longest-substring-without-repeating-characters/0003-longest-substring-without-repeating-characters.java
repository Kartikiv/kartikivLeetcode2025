import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>(); // codePoint -> next char index after its last occurrence
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            int cp = s.codePointAt(right);
            int width = Character.charCount(cp);

            if (map.containsKey(cp)) {
                left = Math.max(left, map.get(cp));
            }

            map.put(cp, right + width);

            int currLen = s.codePointCount(left, right + width);
            maxLen = Math.max(maxLen, currLen);

            right += width;
        }

        return maxLen;
    }
}