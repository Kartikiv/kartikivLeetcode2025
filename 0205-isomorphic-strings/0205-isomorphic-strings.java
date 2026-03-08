import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
    StringBuilder transformS = new StringBuilder();
    StringBuilder transformT = new StringBuilder();
    Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }
            transformS.append(map.get(s.charAt(i))).append(":");
        }
        map.clear();
        for (int i = 0; i < t.length(); i++) {
            if(!map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), i);
            }
            transformT.append(map.get(t.charAt(i))).append(":");
        }
    return transformS.compareTo(transformT) == 0;
    }
}