import java.util.*;

class Solution {
    int[] charMap = new int[26];

    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;

        // reset charMap in case the same Solution object is reused
        Arrays.fill(charMap, 0);

        // charMap = freq(s1)
        for (char c : s1.toCharArray()) {
            charMap[c - 'a']++;
        }

        // subtract first window of size m from s2
        for (int k = 0; k < m; k++) {
            charMap[s2.charAt(k) - 'a']--;
        }

        if (isValidWindow()) return true;

        int i = 0;          // left of window
        int j = m;          // next index to enter the window
        while (j < n) {
            // char leaving window at i
            charMap[s2.charAt(i) - 'a']++;
            i++;

            // char entering window at j
            charMap[s2.charAt(j) - 'a']--;
            j++;

            if (isValidWindow()) return true;
        }

        return false;
    }

    boolean isValidWindow() {
        for (int x : charMap) {
            if (x != 0) return false;
        }
        return true;
    }
}
