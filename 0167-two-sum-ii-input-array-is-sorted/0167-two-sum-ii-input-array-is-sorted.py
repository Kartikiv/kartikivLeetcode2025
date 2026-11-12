class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:

    # Return the indices of the matching pair
        i = 0
        j = len(nums) - 1
        while i < j:
            if nums[i] + nums[j] == target:
                return [i + 1, j + 1]
            if nums[i] + nums[j] > target:
                j -= 1
            else:
                i += 1
        return [-1, -1]
