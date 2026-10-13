class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){ return 0;}
        int[] windowMap = new int[2056];
        int i = 0;
        int maxLength = 1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            windowMap[c]++;
            while (windowMap[c] > 1 && i <= j) {
                char removed = s.charAt(i);
                windowMap[removed]--;
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}