

/**
 * Solution class for computing the minimum edit distance (Levenshtein distance) between two strings.
 * 
 * This class uses dynamic programming with memoization to calculate the minimum number of operations
 * (insert, delete, or replace) needed to transform word1 into word2.
 * 
 * Time Complexity: O(m * n) where m and n are the lengths of word1 and word2
 * Space Complexity: O(m * n) for the DP table
 */
class Solution {
    String word1;
    String word2;
    Integer [][] dp ;
    
    
    /**
     * Computes the minimum edit distance between two strings using memoized recursion.
     * 
     * @param word1 the source string to transform
     * @param word2 the target string to transform into
     * @return the minimum number of edit operations required to transform word1 into word2
     */
    public int minDistance(String word1, String word2) {
        this.word1 = word1; this.word2 = word2;
        this.dp = new Integer [word1.length() + 1][word2.length() + 1];
        return minDistanceRecur(word1.length(), word2.length());
    }

/**
 * Recursive helper method to calculate minimum distance with memoization.
 * 
 * Base cases:
 * - If word1Index is 0, return word2Index (insert all remaining characters from word2)
 * - If word2Index is 0, return word1Index (delete all remaining characters from word1)
 * 
 * Recursive cases:
 * - If characters match, recurse without incrementing operation count
 * - If characters don't match, take the minimum of three operations (insert, delete, replace) and add 1
 * 
 * @param word1Index current index in word1
 * @param word2Index current index in word2
 * @return the minimum edit distance for the remaining substrings
 */
   public int minDistanceRecur( int word1Index, int word2Index ) {
        if(dp[word1Index][word2Index] !=null) return dp[word1Index][word2Index];
        if (word1Index == 0) {
            return word2Index;
        }
        if (word2Index == 0) {
            
            return word1Index;
        }
        if (word1.charAt(word1Index - 1) == word2.charAt(word2Index - 1)) {
            return minDistanceRecur(
                    word1Index - 1,
                    word2Index - 1
            );
        } else {
            int insertOperation = minDistanceRecur(
                    word1Index,
                    word2Index - 1
            );
            int deleteOperation = minDistanceRecur(
                    word1Index - 1,
                    word2Index
            );
            int replaceOperation = minDistanceRecur(
                    word1Index - 1,
                    word2Index - 1
            );
            dp [word1Index][word2Index] = (
                    Math.min(
                            insertOperation,
                            Math.min(deleteOperation, replaceOperation)
                    ) +
                            1
            );
            return  dp [word1Index][word2Index];
        }
    }
}