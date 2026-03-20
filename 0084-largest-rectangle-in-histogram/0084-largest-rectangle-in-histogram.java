import java.util.*;

class StackNode {
    int height;
    int index;

    public StackNode(int height, int index) {
        this.height = height;
        this.index = index;
    }
}

class Solution {
    // brute force n square solution
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<StackNode> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int lastIndex = 0;
            if(!stack.isEmpty() && stack.peek().height > heights[i]){
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                StackNode node = stack.pop();
                int area = node.height * (i - node.index);
                maxArea = Math.max(maxArea, area);
                maxArea = Math.max(maxArea, node.height);
                lastIndex = node.index;
            }
            stack.push(new StackNode(heights[i], lastIndex));
            lastIndex = i;
        }else{
          stack.push(new StackNode(heights[i], i));  
        }
    }
        // remaining height in increasing order
        // the maxheight contributed is 
        int maxIndex = heights.length - 1;
        while (!stack.isEmpty()) {
            StackNode node = stack.pop();
            int area = node.height * (maxIndex - node.index + 1);
            maxArea = Math.max(maxArea, area);
            maxArea = Math.max(maxArea, node.height);
        }
        return maxArea;
    }

}