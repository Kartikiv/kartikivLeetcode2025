
import java.util.List;

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
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int maxDepth;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        this.maxDepth = 0 ;
        int sum = 0 ; 

        int [] ans = new int [2];
        for(NestedInteger num : nestedList){ 
            int [] temp = helper(num, 1);
            ans[0] += temp[0];
            ans[1] += temp[1];
        }
        return (maxDepth + 1 )* (ans[0]) - ans[1]  ; 
    }
    int[] helper(NestedInteger integer, int depth){
        if(integer == null) return new int []{0,0} ;
        maxDepth = Math.max(maxDepth, depth);
        if(integer.isInteger()) {
            return new int [] {integer.getInteger() ,depth * integer.getInteger()};
        }else{
            int sum = 0 ;
            int weightedSum = 0 ;
            for(NestedInteger num : integer.getList()){
                int [] ans = helper(num, depth + 1);
                sum += ans[0];
                weightedSum += ans[1];
            }

        return new int [] {sum,weightedSum} ;}

    }
    
}