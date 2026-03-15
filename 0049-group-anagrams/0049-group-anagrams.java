class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(); 
        for (String str : strs){
            char [] charArr= str.toCharArray(); 
            Arrays.sort(charArr);
            if(!map.containsKey(new String(charArr))) map.put(new String(charArr), new ArrayList<>());
            map.get(new String(charArr)).add(str);
        }
    return map.values().stream().toList();}
}