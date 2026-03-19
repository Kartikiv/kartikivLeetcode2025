class Solution {
    public boolean isValid(String s) {
        // Step 1 : use the inbuilt array as a store and
        // insert open bracket and when we reach the close bracket
        // check if it is the top is the closer else return false
        char[] arr = s.toCharArray();
        int top = -1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            // open bracket push into the stack
            if (c == '(' || c == '{' || c == '[') {
                arr[++top] = c;
            }
            // process cloesed brackets
              if (top == -1)
                    return false;
            if (c == ')') {
                if (arr[top--] != '(')
                    return false;
            }
            if (c == '}') {
                if (arr[top--] != '{')
                    return false;
            }
            if (c == ']') {
                if (arr[top--] != '[')
                    return false;
            }

        }
        return top == -1;
    }
}