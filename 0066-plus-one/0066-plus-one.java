class Solution {
    public int[] plusOne(int[] digits) {
        int [] ans = new int[digits.length];
        int carry = 1;
       
        for (int i = digits.length - 1 ; i >= 0 ; i--){
            int sum = digits[i] + carry ;
            ans[i] = sum % 10;
            carry = sum / 10;
        }
        if (carry != 0 ){
          int []  newAns = new int[digits.length + 1];
          for (int i = digits.length - 1 ; i >= 1 ; i--){
          newAns[i] = ans[i];

          }
          newAns[0] = carry;
          return newAns;

        }
    return ans; }
}