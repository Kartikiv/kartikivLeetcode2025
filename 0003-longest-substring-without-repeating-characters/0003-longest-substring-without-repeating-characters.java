import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxWindow = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < s.length()) {
            int c = s.codePointAt(j);
            int width = Character.charCount(c);

            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c));
            }

            map.put(c, j + width);
            maxWindow = Math.max(maxWindow, s.codePointCount(i, j + width));

            j += width;
        }

        return maxWindow;
    }
}