/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxDepth = 0;
    int depthWeightedSum = 0;
    int sum = 0;
    int totalIntegers = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        for (NestedInteger integer : nestedList)
            dfdHelper(integer, 0);
        return (maxDepth + 1) * sum - depthWeightedSum;

    }

    public void dfdHelper(NestedInteger nestedInteger, int depth) {
        depth++;
        maxDepth = Math.max(maxDepth, depth);
        if (nestedInteger.isInteger()) {
            sum += nestedInteger.getInteger();
            depthWeightedSum += nestedInteger.getInteger() * depth;
            totalIntegers++;
            return;
        }
        for (NestedInteger integer : nestedInteger.getList()) {
            dfdHelper(integer, depth);
        }
    }
}