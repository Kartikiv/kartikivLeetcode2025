
class Solution {
    String s;
    int k;

    /**
     * Solves the Longest Repeating Character Replacement problem.
     * 
     * Given a string s and an integer k, finds the length of the longest substring
     * containing the same letter that can be obtained by performing at most k
     * replacements
     * of any other characters.
     * 
     * @param s the input string consisting of uppercase English letters
     * @param k the maximum number of character replacements allowed
     * @return the length of the longest substring with the same repeating character
     *         after at most k replacements
     * 
     *         Algorithm:
     *         Uses a sliding window approach with two pointers (i, j) to maintain a
     *         valid window.
     *         A window is valid if the number of characters that need to be
     *         replaced is at most k.
     *         - Tracks the frequency of each character in the current window using
     *         a character frequency map
     *         - Expands the window by moving the right pointer (j)
     *         - Contracts the window by moving the left pointer (i) when the window
     *         becomes invalid
     *         - Maintains the maximum frequency of any character in the current
     *         window
     *         - Returns the maximum window size encountered
     * 
     *         Time Complexity: O(n) where n is the length of string s
     *         Space Complexity: O(1) as the character frequency map has a fixed
     *         size of 26
     */
    public int characterReplacement(String s, int k) {
        this.s = s;
        this.k = k;
        int maxLen = 1;
        int i = 0;
        int j = 0;
        int maxFreq = 0;
        int[] charMap = new int[26];
        while (j < s.length()) {

            charMap[s.charAt(j) - 'A'] = charMap[s.charAt(j) - 'A'] + 1;
            maxFreq = Math.max(maxFreq, charMap[s.charAt(j) - 'A']);

            while (!isValidWindow(i, j, maxFreq)) {
                charMap[s.charAt(i) - 'A']--;
                i++;
                int temp = 1;
                for (int freq : charMap) {
                    temp = Math.max(freq, temp);
                }
                maxFreq = temp;
            }
            maxLen = Math.max(maxLen, (j - i) + 1);
            j++;
        }
        return maxLen;
    }

    /**
     * Validates whether a window is valid for character replacement.
     * 
     * A window [i, j] is valid if the number of characters that need to be replaced
     * to make all characters the same is at most k.
     * The number of replacements needed = window size - max character frequency
     * 
     * @param i       the left pointer of the window
     * @param j       the right pointer of the window
     * @param maxFreq the maximum frequency of any character in the window
     * @return true if the window can be made into a string of same characters with
     *         at most k replacements,
     *         false otherwise
     */

    boolean isValidWindow(int i, int j, int maxFreq) {
        return (j - i) + 1 - maxFreq <= k;
    }
}