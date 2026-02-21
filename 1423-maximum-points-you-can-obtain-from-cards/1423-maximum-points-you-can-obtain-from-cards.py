import math


class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        def slidingWindow(k) -> int:
            sum = 0 
            left = 0
            minSum = math.inf
            for i in range(k):
                sum += cardPoints[i]
            for i in range(k , len(cardPoints)):
                minSum = min(sum, minSum)
                sum -= cardPoints[left]
                left += 1
                sum += cardPoints[i]
            minSum = min(sum, minSum)
            return minSum
        totalSum = 0 
        for i in range(len(cardPoints)):
            totalSum += cardPoints[i]
        totalSum = totalSum - slidingWindow(len(cardPoints) - k)
        return totalSum



