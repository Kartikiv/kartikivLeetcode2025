class Solution {
    public String decodeString(String s) {

        // Stack will store characters of the final decoded string.
        // We process left to right, but when we see ']', we resolve that encoded part.
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // When we see ']', it means one encoded block is complete
            // Example: 3[a2[c]] -> when we hit ']', we must decode the innermost part
            if (c == ']') {

                // This list will store characters inside the current [ ... ]
                // We pop until we find '['
                List<Character> charList = new ArrayList<>();

                while (!stack.isEmpty() && stack.peek() != '[') {
                    charList.add(stack.pop());
                }

                // Now the top of stack is '[' → remove it
                stack.pop();

                // Now we must extract the number k that appears before '['
                // Since stack is LIFO, digits come in reverse order
                // Example: "12[a]" → stack has '1','2','[' → popping gives 2 then 1
                int base = 1;
                int k = 0;

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }

                // Now we have:
                // charList → reversed substring
                // k → number of times it must repeat

                // We push the substring back k times
                // We reverse charList while pushing to maintain correct order
                while (k != 0) {
                    for (int j = charList.size() - 1; j >= 0; j--) {
                        stack.push(charList.get(j));
                    }
                    k--;
                }
            }
            else {
                // For normal characters, digits, and '['
                // Just push them to the stack
                stack.push(c);
            }
        }

        // Now the stack contains the fully decoded string
        // But it is in reverse order (because stack is LIFO)
        char[] result = new char[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return new String(result);
    }
}
