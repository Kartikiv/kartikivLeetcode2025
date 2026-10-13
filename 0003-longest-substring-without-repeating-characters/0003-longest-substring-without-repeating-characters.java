class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){ return 0;}
        int[] windowMap = new int[512];
        Arrays.fill(windowMap, -1);
        int i = 0;
        int maxLength = 1;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j); 
           
            if (windowMap[c] >= i) {
                i = windowMap[c] + 1;
            }
            windowMap[c] = j;
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}