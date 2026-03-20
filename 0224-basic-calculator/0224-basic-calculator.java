import java.util.*;

class Solution {
    public int calculate(String s) {
        int n = s.length();
        int result = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();
        stack.push(1); // outermost sign context

        int i = 0;
        while (i < n) {
            char c = s.charAt(i);

            if (c == ' ') {
                i++;
            } 
            else if (c == '+') {
                sign = stack.peek();
                i++;
            } 
            else if (c == '-') {
                sign = -stack.peek();
                i++;
            } 
            else if (c == '(') {
                stack.push(sign);
                i++;
            } 
            else if (c == ')') {
                stack.pop();
                i++;
            } 
            else if (Character.isDigit(c)) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                result += sign * num;
            }
        }

        return result;
    }
}