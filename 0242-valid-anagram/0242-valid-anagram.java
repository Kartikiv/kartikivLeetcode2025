class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freqMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // increment the freq 
            freqMap[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            // increment the freq 
            freqMap[t.charAt(i) - 'a']--;
        }
        for (int num : freqMap) {
            if (num != 0)
                return false;
        }
        return true;
    }
}