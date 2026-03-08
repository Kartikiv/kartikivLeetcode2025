class Solution {
    public double myPow(double x, int n) {
        long power = n; 
        if(x == 0 && power == 0) return 1; 
        if(x == 0 ) return 0; 
        if(power == 0 ) return 1;
        if(n < 0){
            x = 1/x;
            power = -1 * power;
        }
        double result = 1; 
        while(power > 0){
            if(power % 2 == 1){
                result *= x;
               
            }
            x *= x;
            power = power / 2;

        }
       

    return result; 
    }
}