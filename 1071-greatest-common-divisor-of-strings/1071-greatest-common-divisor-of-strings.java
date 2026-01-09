class Solution {
    public int gcd (int a, int b ){
        while (b != 0) {
            int temp = b;
            b = a % b; // Replace b with the remainder of a % b
            a = temp;  // Replace a with the old value of b
        }
        return a; // When b becomes 0, a is the GCD
    }
    public String gcdOfStrings(String str1, String str2) {
        String c1 =str1 + str2;
        String c2 =str2 + str1;
        
      if(!c1.equals(c2)) return "";
      int len = gcd(str1.length(), str2.length());
      


      return str1.substring(0, len);
    }
      
}