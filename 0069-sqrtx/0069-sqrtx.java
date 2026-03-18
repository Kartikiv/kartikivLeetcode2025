class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x ;
        
        double ans = x / 2 ;
        int i = 0 ;
        while (i < 100) {
            ans = interpolation(ans, x);
            i++;
        }
    return (int) ans ;
}
    public double interpolation(double guess , int x){
        return (guess + (x / guess)) / 2 ;
    }
}