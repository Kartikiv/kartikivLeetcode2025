import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // expand  the window till you hit a repeating char then start from that position 
        int i = 0; 
        int j = 0; 
        int maxWindow = 0 ; 
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()) {
           char c = s.charAt(j);
           while(set.contains(c)){
            set.remove(s.charAt(i));
            i++;
           }
           
           set.add(c);
           maxWindow = Math.max(j - i + 1, maxWindow);
           j++;
        }
    return maxWindow; 
  }
}