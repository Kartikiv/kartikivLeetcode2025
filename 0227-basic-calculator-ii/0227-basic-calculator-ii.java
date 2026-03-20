import java.util.*;

class Solution {
    public int calculate(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int currentNumber = 0 ;
        char operator = '+';
        while (index < arr.length) {
            if (Character.isDigit(arr[index])) {
                while (index < arr.length && Character.isDigit(arr[index])) {
                    currentNumber = currentNumber * 10 + (arr[index] - '0');
                    index++;
                }
                index--; 
            }
            if(!Character.isDigit(arr[index]) && !Character.isWhitespace(arr[index]) || index == arr.length - 1){
                // process previous operation 
                if(operator == '+'){
                    stack.push(currentNumber);
                }else if(operator == '-'){
                    stack.push(-1 * currentNumber);
                }else if(operator == '*'){
                    stack.push(stack.pop() * currentNumber);
                }else if(operator == '/'){
                    stack.push(stack.pop() / currentNumber);
                }
                // update new operator
                operator = arr[index];
                currentNumber = 0 ;

            }
            
            index++;
        }
        // do addtion and subtraction operation 
        int result = 0 ; 
        while (!stack.isEmpty()) {
           result += stack.pop(); 
        }

    return result
    ; 
}
}