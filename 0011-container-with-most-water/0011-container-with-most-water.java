/**
 * The Solution class provides a method to calculate the maximum area
 * that can be formed between two vertical lines represented by an array
 * of heights. The area is determined by the distance between the lines
 * and the height of the shorter line.
 */
class Solution {
    /**
     * Calculates the maximum area of water that can be trapped between
     * two lines represented by the heights in the given array.
     *
     * @param height an array of integers where each integer represents
     *               the height of a vertical line.
     * @return the maximum area of water that can be trapped between
     *         two lines.
     */
    /**
     * Calculates the maximum area of water that can be trapped between two vertical
     * lines
     * represented by the heights in the given array.
     *
     * The function uses a two-pointer approach to find the maximum area by
     * iterating through
     * the array from both ends towards the center. At each step, it calculates the
     * area formed
     * by the lines at the two pointers and updates the maximum area if the current
     * area is larger.
     * The pointers are moved inward based on the height of the lines to potentially
     * find a larger area.
     *
     * @param height an array of integers where each integer represents the height
     *               of a vertical line
     * @return the maximum area of water that can be trapped between two lines
     */
    public int maxArea(int[] height) {
        // method implementation
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            maxArea = Math.max(area, maxArea);
            if (height[j] > height[i]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}