
import java.util.Currency;

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        // basic multiplication 
        if (num1.compareTo(num2) < 0) {
            return multiply(num2, num1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder current = new StringBuilder();
            int carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int product = Integer.parseInt(num1.charAt(j) + "") * Integer.parseInt(num2.charAt(i) + "");
                product += carry;
                carry = product / 10;
                current.append(product % 10);
            }
            if (carry > 0) {
                current.append(carry);
            }
            for (int zero = num2.length() - 1 - i; zero > 0; zero--) {
                current.insert(0, 0);
            }
            sb = add(sb, current);
        }

        return sb.reverse().toString();
    }

    public StringBuilder add(StringBuilder sb1, StringBuilder sb2) {
        StringBuilder sb = new StringBuilder();
        if (sb1.length() < sb2.length()) {
            return add(sb2, sb1);
        }
        int carry = 0;
        for (int i = 0; i < sb1.length(); i++) {
            int sb1Num = Integer.parseInt(sb1.charAt(i)+"");
            int sb2Num = i < sb2.length()? Integer.parseInt(sb2.charAt(i)+"") : 0;
            int sum = sb1Num + sb2Num + carry; 
            carry = sum / 10; 
            sb.append(sum % 10);
        }
        if(carry > 0){ 
            sb.append(carry);
        }
    return sb; 
    }

}