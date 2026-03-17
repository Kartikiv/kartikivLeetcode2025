class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int [] patternMap = getSignature(pattern);
        for (String s : words){
            if(s.length() != pattern.length()) {
                continue;
            }

            int [] sMap = getSignature(s);
            for(int i = 0 ; i < s.length(); i++){
                if(sMap[s.charAt(i) - 'a'] != patternMap[pattern.charAt(i) - 'a']){
                    break;
                }
                if(i == s.length() - 1) {
                    ans.add(s);
                }

            }
            
        }
    return ans; 
    }

    int [] getSignature(String s) {
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 0) {
                map[s.charAt(i) - 'a'] = i + 1;
            }
        }
        return map;
    }
}