class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int longestSubString = 1;
        int i = 0; 
        int j = 0; 
        HashMap<Character, Integer> map = new HashMap<>();
        while(j < s.length()){ 
            if(map.containsKey(s.charAt(j))){ 
                i = Math.max(i,map.get(s.charAt(j)) + 1);
            }
                map.put(s.charAt(j), j);
            longestSubString = Math.max(longestSubString, j - i + 1);
            j++;
        } 
    return longestSubString; 
    }
}