
class Solution {
    int k;

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