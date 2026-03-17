import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // expand  the window till you hit a repeating char then start from that position 
        int i = 0; 
        int j = 0; 
        int maxWindow = 0 ; 
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < s.length()) {
          int c = s.codePointAt(j);
          int width = Character.charCount(c);
           if(map.containsKey(c)){
            i = Math.max(i, map.get(c) + 1);
           }
           map.put(c, j);
           maxWindow = Math.max(maxWindow, j - i + 1);
           j = j + width;
        }
    return maxWindow; 
  }
}