class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (String s : words){
            if(isMatch(s, pattern)){
                ans.add(s);
            }            
        }
    return ans; 
    }

    boolean isMatch(String s,String p) {
        int[] wMap = new int[26];
        int [] pMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if(wMap[s.charAt(i) - 'a'] != pMap[p.charAt(i) - 'a']){
                return false;
            }
            if (wMap[s.charAt(i) - 'a'] == 0) {
                wMap[s.charAt(i) - 'a'] = i + 1;
            }
            
            if (pMap[p.charAt(i) - 'a'] == 0) {
                pMap[p.charAt(i) - 'a'] = i + 1;
            }
        }

        return true;
    }
}