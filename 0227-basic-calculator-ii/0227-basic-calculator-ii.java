import java.util.Stack;

class Solution {
    public int calculate(String s) {
        // so we parse the number and when hit an operator we simply
        // do the operation in the previous operator
        // and we move forward with the operations
        Stack<Long> stack = new Stack<>();
        char operator = '+'; // initial operator
        int index = 0;
        long result = 0;
        long currentNumber = 0;
        int length = s.length();
        while (index < length) {
            if (Character.isDigit(s.charAt(index))) {
                while (index < length && Character.isDigit(s.charAt(index))) {
                    // parsing the digits to number
                    currentNumber = currentNumber * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index--; // go back on char as it was not a number.

            }
            // process operator and also process operation if reach the end to the string
             if ((!Character.isDigit(s.charAt(index)) &&
                    !Character.isWhitespace(s.charAt(index)))
                    || index == length - 1) {
                // do the previous operation and push the result onto the stack
                if (operator == '+' || operator == '-') {
                    int sign = operator == '+' ? 1 : -1;
                    stack.add(sign * currentNumber);
                }
                // For division and multiplication only compute 
                if (operator == '/') {
                    stack.add(stack.pop() / currentNumber);
                }
                if (operator == '*') {
                    stack.add(stack.pop() * currentNumber);
                }
                //update the operator and currentNumber
                currentNumber = 0 ; 
                operator = s.charAt(index);

            }
            index++;
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

   return (int) result; 
 }
}