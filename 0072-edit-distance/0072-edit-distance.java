public class Solution {
    String word1;
    String word2;
    Integer [][] dp ;
    public int minDistance(String word1, String word2) {
        this.word1 = word1; this.word2 = word2;
        this.dp = new Integer [word1.length() + 1][word2.length() + 1];
        return minDistanceRecur(word1.length(), word2.length());
    }

    int minDistanceRecur( int word1Index, int word2Index ) {
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