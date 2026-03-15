class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(); 
        for (String str : strs){
            String key = getSignature(str);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
    return map.values().stream().toList();}
    
    String getSignature(String key){
        StringBuilder sb = new StringBuilder();
        int [] charFreq = new int [26]; 
        for(char c : key.toCharArray()){
            charFreq[c - 'a']++;
        }
        for(int i : charFreq){
            sb.append(i).append("#");
        }
    return sb.toString(); 
    }
}