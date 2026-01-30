// create a wind of length p and move the window one character at a time
// if the frequency is the same add the begin index and move on.
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int[] windowFreq = new int[26];
        int left = 0;
        int j = p.length() - 1;
        for(int i = 0 ; i < p.length(); i++){
            windowFreq[p.charAt(i) - 'a']++;
        }
        for(int i = 0 ; i < p.length(); i++){
            windowFreq[s.charAt(i) - 'a']--;
        }

        while (j < s.length() - 1) {
            if(isValidWindow(windowFreq)){
                ans.add(left);
            }
            windowFreq[s.charAt(left) - 'a']++;
            left++;
            j++;
            windowFreq[s.charAt(j) - 'a']--;
        }
        if(isValidWindow(windowFreq)){
            ans.add(left);
        }
  return ans;
  }

    boolean isValidWindow(int[] windowFreq) {
        for (int num : windowFreq) {
            if (num != 0)
                return false;
        }
        return true;
    }
}