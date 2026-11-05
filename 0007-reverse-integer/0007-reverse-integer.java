class Solution {
    // 2,147,483,647
    // 2,147,483,641
    public int reverse(int x) {
        int reversed = 0;
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        while (x > 0) {
            int digit = x % 10;
            x = x / 10;

            if(reversed > Integer.MAX_VALUE / 10 ||(reversed == Integer.MAX_VALUE / 10 && digit > 7)){ 
                return 0;
            }
            reversed = reversed * 10 + digit;

        }
        return sign * reversed;
    }
}