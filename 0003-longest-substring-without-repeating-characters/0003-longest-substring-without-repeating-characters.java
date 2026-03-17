import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // expand  the window till you hit a repeating char then start from that position 
        int i = 0; 
        int j = 0; 
        int maxWindow = 0 ; 
        int [] map = new int[256];
        while (j < s.length()) {
          char c = s.charAt(j);
           if(map[c] != 0){
            i = Math.max(i, map[c]);
           }
           map[c]  = j + 1;
           maxWindow = Math.max(maxWindow, j - i + 1);
           j++;
        }
    return maxWindow; 
  }
}