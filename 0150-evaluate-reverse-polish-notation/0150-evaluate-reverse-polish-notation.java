import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>(tokens.length);

        for (String t : tokens) {
            switch (t) {
                case "+" -> {
                    ensure(st, 2);
                    int b = st.pop(), a = st.pop();
                    st.push(a + b);
                }
                case "-" -> {
                    ensure(st, 2);
                    int b = st.pop(), a = st.pop();
                    st.push(a - b);
                }
                case "*" -> {
                    ensure(st, 2);
                    int b = st.pop(), a = st.pop();
                    st.push(a * b);
                }
                case "/" -> {
                    ensure(st, 2);
                    int b = st.pop(), a = st.pop();
                    if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                    st.push(a / b); // truncates toward zero in Java
                }
                default -> {
                    // Handles negatives too (e.g., "-11")
                    st.push(Integer.parseInt(t));
                }
            }
        }

        if (st.size() != 1) throw new IllegalStateException("Invalid RPN expression");
        return st.pop();
    }

    private static void ensure(Deque<Integer> st, int need) {
        if (st.size() < need) throw new IllegalStateException("Insufficient operands");
    }
}
