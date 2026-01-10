class Solution {
    public String decodeString(String s) {
        Stack <Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if( c == ']'){
                List<Character> charList = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '['){
                    charList.add(stack.pop());
                }
                stack.pop();
                int base = 1;
                int k = 0;
                // get the number k
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }

                while (k != 0) {
                    for (int j = charList.size() - 1; j >= 0; j--) {
                        stack.push(charList.get(j));
                    }
                    k--;
                }
             }
             else{
                    stack.push(c);
                }
        }




 char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
}