import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>ans = new ArrayList<>();
        HashMap<String, List<String>>map = new HashMap();
        for(String s : strs){
            char [] sArr = s.toCharArray();
            Arrays.sort(sArr);

            String key = new String(sArr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);


        }

        for (List <String> list: map.values()){
            ans.add(list);
        }
    return ans; 
}
}