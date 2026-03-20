import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Hash num1 with indicies
        HashMap<Integer, Integer> mapNum1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            mapNum1.put(nums1[i], i);
            nums1[i] = -1;
        }

        // use a stack and the stack store elements in a decreasing order
        // i.e push if only if peek > currentelement
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            if (stack.isEmpty()) {
                if (mapNum1.containsKey(nums2[i]))
                    stack.add(nums2[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                    int num = stack.pop();
                    nums1[mapNum1.get(num)] = nums2[i];
                }
                if (mapNum1.containsKey(nums2[i]))
                    stack.add(nums2[i]);

            }

        }
        return nums1;
    }
}