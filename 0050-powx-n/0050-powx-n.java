class Solution {
    public double myPow(double x, int n) {
        long power = n;
        // poweregative powers 
        if (power < 0) {
            power = -power;
            x = 1 / x;
        }
        double result = 1;
        while (power > 0) {

            if ((power & 1) == 1) {
                result *= x;
            }
            x *= x;
            power = power >> 1;

        }

        return result;
    }
}
