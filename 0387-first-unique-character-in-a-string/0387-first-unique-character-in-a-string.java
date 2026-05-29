class Solution {
    public int firstUniqChar(String s) {
        // First Unique Character 
        int [] charMap = new int [26];
        for(int i = 0 ; i < s.length() ; i++){ 
            if(charMap[s.charAt(i) - 'a'] == 0){ 
                charMap[s.charAt(i) -'a'] = i + 1;
            }else{
                charMap[s.charAt(i) - 'a'] = -1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(charMap[s.charAt(i) - 'a']  > 0) return charMap[s.charAt(i) - 'a'] - 1;
        }
    return - 1;
    }
}