class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        // dp[i] stores the length of the longest valid parentheses substring ENDING at index i-1 of s
        int dp[] = new int[n]; 
        int maxLen = 0;
        char[] sArr = s.toCharArray();
        
        // Start loop from the second character (index 1)
        for (int i = 1; i < n; i++) {
            if (sArr[i] == ')') {
                
                // Case 1: ...()
                if (sArr[i - 1] == '(') {
                    // Length is 2 + length of valid substring ending at i-2
                    int prevLen = (i >= 2) ? dp[i - 2] : 0;
                    dp[i] = prevLen + 2;
                } 
                
                // Case 2: ...))
                else if (sArr[i - 1] == ')') {
                    // Find the index of the potential matching '('
                    // It should be at i - dp[i-1] - 1
                    int matchingOpenParenIndex = i - dp[i - 1] - 1;

                    // Check if the matching '(' exists and is within bounds
                    if (matchingOpenParenIndex >= 0 && sArr[matchingOpenParenIndex] == '(') {
                        
                        // New valid block length: dp[i-1] + 2
                        dp[i] = dp[i - 1] + 2;

                        // Add the length of the valid substring immediately preceding the new block
                        // This substring ends at index: matchingOpenParenIndex - 1
                        if (matchingOpenParenIndex >= 1) {
                            dp[i] += dp[matchingOpenParenIndex - 1];
                        }
                    }
                }
            }
            // If sArr[i] is '(', dp[i] remains 0 (by default initialization)
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}