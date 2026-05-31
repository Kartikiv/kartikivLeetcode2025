class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freqMap = new int[26];
        // put a frequency array of the magazine as it is the source
        for (int i = 0; i < magazine.length(); i++) {
            freqMap[magazine.charAt(i) - 'a']++;
        }
        // use the dictionary of characters in reconstruction 
        for (int i = 0; i < ransomNote.length(); i++) {
            if(freqMap[ransomNote.charAt(i) - 'a'] < 1) return false; 
            // use the character
            freqMap[ransomNote.charAt(i) - 'a']--;
        }

    return true; }
}