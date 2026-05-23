class Solution {
    public int myAtoi(String s) {
        if(s.isBlank()) return 0;
        /**
         * Approach : Parse Charater By Character ignore leading whiteSpaces
         * Go till the end or till we hit a non - digit Character
         */
        int i = 0;
        // Skiping leading zeros
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        int ans = 0;
        int sign = 1;
        if (s.charAt(i) == '-') {
            i++;
            sign = -1;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        while (i < s.length()) {

            if (Character.isDigit(s.charAt(i))) {
                if (ans > Integer.MAX_VALUE / 10) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }else if(ans == Integer.MAX_VALUE / 10){
                    if(sign == -1 && s.charAt(i) - '0' >= 8) return Integer.MIN_VALUE; 
                    if(sign == 1 && s.charAt(i) - '0' > 7) return Integer.MAX_VALUE; 
                }
                
                ans *= 10;
                ans += s.charAt(i) - '0';
            } else {
                break;
            }
            i++;
        }

        return sign * ans;
    }
}
