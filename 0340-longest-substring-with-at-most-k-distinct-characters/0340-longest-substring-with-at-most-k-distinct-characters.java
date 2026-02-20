
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0; 
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k){
                c = s.charAt(i);
                int freq = map.getOrDefault(c, 0) ;
                freq = freq - 1; 
                if(freq <= 0 ){
                    map.remove(c);
                }else{
                     map.put(c, map.getOrDefault(c, 0) - 1);
                }
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
    return maxLen; 
}
}