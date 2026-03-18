class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";
        if (s.equals(t))
            return s;
        // step 1 : Frequency map of t
        int[] tMap = new int[60];
        int needed = 0;
        for (int i = 0; i < t.length(); i++) {
            if (tMap[t.charAt(i) - 'A'] == 0)
                needed++;
            tMap[t.charAt(i) - 'A']++;
        }
        int minl = -1;
        int minr = -1;
        int formed = 0;

        // Step 2 : apply sliding window and move right till the window is valid 
        // window is valid when formed == neeeded 
        // when window is valid move left pointer right till the window becomes invalid while moving get the minwindow 
        int i = 0;
        int j = 0;
        int[] sMap = new int[60];
        while (j < s.length()) {
            // expand till valid
            sMap[s.charAt(j) - 'A']++;
            if (tMap[s.charAt(j) - 'A'] != 0 && tMap[s.charAt(j) - 'A'] == sMap[s.charAt(j) - 'A']) {
                formed++;
            }

            // shrink here
            while (i <= j && formed == needed) {
                if (minl == -1 || j - i < minr - minl) {
                    minl = i;
                    minr = j;
                }
                sMap[s.charAt(i) - 'A']--;
                if (tMap[s.charAt(i) - 'A'] != 0 && sMap[s.charAt(i) - 'A'] < tMap[s.charAt(i) - 'A']) {
                    formed--;
                }
                i++;
            }

            j++;

        }

        return minl == -1 ? "" : s.substring(minl, minr + 1);
    }

}