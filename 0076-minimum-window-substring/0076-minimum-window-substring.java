import java.util.Arrays;

class Solution {
    int[] charMap = new int[58];
    int missing;       // NEW: how many chars still needed
    String s2;

    public String minWindow(String s1, String s2) {
        if (s1.length() < s2.length()) return "";

        Arrays.fill(charMap, 0);  // important if Solution reused across tests
        this.s2 = s2;

        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        int minLen = Integer.MAX_VALUE;
        int i = 0;

        // build requirement map
        for (char c : s2.toCharArray()) {
            charMap[c - 'A']++;
        }
        missing = s2.length();

        for (int j = 0; j < s1.length(); j++) {
            int idxR = s1.charAt(j) - 'A';

            // consume right char
            if (charMap[idxR] > 0) missing--;
            charMap[idxR]--;

            while (isValid()) { // O(1) now
                int len = j - i + 1;
                if (len < minLen) {
                    minLen = len;
                    ans[0] = j;
                    ans[1] = i;
                }

                int idxL = s1.charAt(i) - 'A';
                charMap[idxL]++;

                // if we now "owe" this char again, window becomes invalid
                if (charMap[idxL] > 0) missing++;

                i++;
            }
        }

        if (ans[0] == -1) return "";
        return s1.substring(ans[1], ans[0] + 1);
    }

    boolean isValid() {
        return missing == 0;
    }
}
