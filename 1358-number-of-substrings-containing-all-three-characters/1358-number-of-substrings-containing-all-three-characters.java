class Solution {
    public int numberOfSubstrings(String s) {
        // Optimized approach using preposesing the last index of the characters
        int countSubstring = 0;
        int[] charCountArr = new int[3];
        Arrays.fill(charCountArr, -1);
        for (int i = s.length() - 1; i >= 0; i--) {
            int lastChar = 0;
            charCountArr[s.charAt(i) - 'a'] = i;
            lastChar = charCountArr[0] == -1 || charCountArr[1] == -1 || charCountArr[2] == -1 ? -1
                    : Math.max(Math.max(charCountArr[0], charCountArr[1]), charCountArr[2]);
            if (lastChar != -1) {
                countSubstring += s.length() - lastChar;
            }

        }
        return countSubstring;
    }
}