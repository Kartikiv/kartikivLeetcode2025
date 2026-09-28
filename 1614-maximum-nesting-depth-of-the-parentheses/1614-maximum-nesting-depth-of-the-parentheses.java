class Solution {
    public int maxDepth(String s) {
        // Perform the same calculation
        // every char is a either a digit, bracket or a operator
        int maxDepth = 0;
        int currentDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isOpenBracket(c)) {
                currentDepth++;
            }
            if (isClosingBracket(c)) {
                currentDepth--;
            }
            maxDepth = Math.max(currentDepth, maxDepth);
        }
        return maxDepth;
    }

    public boolean isOpenBracket(char c) {
        if (c == '(') {
            return true;
        }
        return false;
    }

    public boolean isClosingBracket(char c) {
        if (c == ')') {
            return true;
        }
        return false;
    }

    public boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    public boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '/' || c == '*') {
            return true;
        }
        return false;
    }
}