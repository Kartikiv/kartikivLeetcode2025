import java.util.*;
/*
 * ==================== PROBLEM FRAMEWORK ====================
 * 1) Pattern: Sliding Window
 * 2) Inputs/Guarantees: s and p consist of lowercase English letters; p.length() <= s.length()
 * 3) Goal: Find all starting indices where an anagram of p appears in s
 * 4) Invariant: Window size is always p.length(); frequency array tracks differences
 * 5) Decision Rules: Add index to answer if frequency array is all zeros (anagram match)
 * 6) Why correct: Sliding window ensures we check every substring of length p.length(); frequency matching confirms anagram
 * 7) Complexity: Time O(n), Space O(1)
 * ============================================================
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int[] windowFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            windowFreq[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            windowFreq[s.charAt(i) - 'a']--;
        }
        if(isValid(windowFreq)) answer.add(0);
        for (int i = 0, j = p.length(); j < s.length(); j++) {
            windowFreq[s.charAt(j) - 'a']--;
            windowFreq[s.charAt(i) - 'a']++;
            
            i++;
            if (isValid(windowFreq)) answer.add(i);
        }
    return answer; 
}

    boolean isValid(int[] windowFreq) {
        for (int num : windowFreq) {
            if (num != 0)
                return false;
        }
        return true;
    }
}