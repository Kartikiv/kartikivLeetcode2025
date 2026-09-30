class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int minI = 0;
        int minJ = s.length();
        int needed = 0;
        int minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c))
                needed++;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    needed--;
                }
            }
            // expand till the condition is valid
            while (i <= j && needed == 0) {
                if (j - i < minJ - minI) {
                    minI = i;
                    minJ = j;
                    minLen = j - i;
                }
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);

                    if (map.get(s.charAt(i)) > 0) {
                        needed++;
                    }
                }

                i++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minI, minJ + 1);
    }
}
/*

import java.util.HashMap;

/**
 * Find the shortest substring containing every required character with its
 * multiplicity.
 *
 * <p>
 * Contract: s and t contain ASCII characters. Return the earliest window on
 * ties,
 * or the empty string if t is empty or no window exists.
 *
 * <p>
 * Example: s="ADOBECODEBANC", t="ABC" returns "BANC".
 * <p>
 * Target: O(s.length() + t.length()) time and O(1) alphabet space.

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        int indexI = 0;
        int indexJ = s.length();
        int needed = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c))
                needed++;
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    needed--;
                }
            }
            // expand till the condition is valid
            while (i < j && needed == 0) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                }
                if (map.get(s.charAt(i)) > 0) {
                    needed++;
                }
                if (j - i < indexJ - indexI) {
                    indexI = i;
                    indexJ = j;
                }
            }

        }
        return s.substring(indexI, indexJ + 1);
    }
}

*/