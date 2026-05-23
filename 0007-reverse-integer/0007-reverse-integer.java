class Solution {
    public int reverse(int x) {
        int rev = 0;
        int sign = x > 0 ? 1 : -1;
        x = x > 0 ? x : -1 * x;
        while (x > 0) {
            if(rev > Integer.MAX_VALUE / 10 ) {
                 return 0; 
            }
            if (sign == 1 && rev == Integer.MAX_VALUE / 10 && x % 10  > 7) return 0;
            if (sign == -1 && rev == Integer.MAX_VALUE / 10 && x % 10  >  8) return 0;
            rev *= 10;
            rev += x % 10;
            x = x / 10;
        }
        // overflow occur the sign flips

        return sign * rev;
    }
}