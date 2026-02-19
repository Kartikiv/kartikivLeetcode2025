import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return new ArrayList<>();
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