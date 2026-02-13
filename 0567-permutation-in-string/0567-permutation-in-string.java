
import java.util.*;

class Solution {
    /*
     * ==================== PROBLEM FRAMEWORK ====================
     * 1) Pattern: SLiding window
     * 2) Inputs/Guarantees:
     * 3) Goal:
     * 4) Invariant:
     * 5) Decision Rules:
     * 6) Why correct:
     * 7) Complexity: Time O(), Space O()
     * ============================================================
     */
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> s1HashMap = new HashMap<>();
        HashMap<Character, Integer> s2HashMap = new HashMap<>();
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        for (char c : s1Arr) {
            s1HashMap.put(c, s1HashMap.getOrDefault(c, 0) + 1);

        }
        int i = 0;
        int j = 0;
        while (j < s1Arr.length) {
            s2HashMap.put(s2Arr[j], s2HashMap.getOrDefault(s2Arr[j], 0) + 1);
            j++;
        }
        while (j < s2Arr.length) {
            if (s1HashMap.equals(s2HashMap))
                return true;
            // remove i
            int freq = s2HashMap.getOrDefault(s2Arr[i], 0) - 1;
            if (freq == 0) {
                s2HashMap.remove(s2Arr[i]);
            } else {
                s2HashMap.put(s2Arr[i], freq);
            }

            // add j
            s2HashMap.put(s2Arr[j], s2HashMap.getOrDefault(s2Arr[j], 0) + 1);
            i++;
            j++;

        }
        return s1HashMap.equals(s2HashMap);
    }
}