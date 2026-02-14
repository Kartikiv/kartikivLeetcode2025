
class Solution {
    int k;
    /*
     * ==================== PROBLEM FRAMEWORK ====================
     * 1) Pattern: Sliding Window 
     * 2) Inputs/Guarantees: String s and k 
     * 3) Goal: return the maximum window length after the character
     * replacement
     * 4) Invariant: we maintain a window which isvalid and in the valid window
     * the condition is j - i + 1 - maxFreq <= k.
     * 5) Decision Rules: if window is invalid move the i pointer towards the right.
     * 6) Why correct: we are always maintiaining a window where all the replacements are possible.
     * 7) Complexity: Time O(n), Space O(1).
     * ============================================================
     */
    public int characterReplacement(String s, int k) {
        this.k = k;
        int[] charMap = new int[26];
        char[] charArr = s.toCharArray();
        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int maxLen = 0;
        while (j < k) {
            charMap[charArr[j] - 'A']++;
            maxFreq = Math.max(maxFreq, charMap[charArr[j] - 'A']);
            j++;
        }
        if(k == charArr.length){
            if(isValidWindow(0, k, maxFreq)){
                return k;
            }else{
                return 0 ;
            }
        }
        while (j < charArr.length) {
            charMap[charArr[j] - 'A']++;
            maxFreq = Math.max(maxFreq, charMap[charArr[j] - 'A']);
            while (!isValidWindow(i, j, maxFreq)) {
                charMap[charArr[i] - 'A']--;
                i++;
                for (int num : charMap) {
                    maxFreq = Math.max(maxFreq, num);
                }
            }
            maxLen = Math.max(maxLen, j - i + 1);

            j++;
        }
        return maxLen;
    }

    boolean isValidWindow(int i, int j, int maxFreq) {
        return (j - i + 1 - maxFreq) <= k;
    }
}