class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        char [] sArr = s.toCharArray();
        char [] tArr = t.toCharArray();
        int maxLen = 0;
        for (int i = 0, j = 0; j < tArr.length; j++) {
            maxCost -= Math.abs(sArr[j] - tArr[j]);
            while (!isValid(maxCost)) {
                maxCost += Math.abs(sArr[i] - tArr[i]);
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
    return  maxLen; 
}

    boolean isValid(int maxCost){
        return maxCost >= 0;
    }
}