class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        map = dict()
        for i in range(len(nums)):
            if target - nums[i] in map:
                return [map[target - nums[i]], i]
            map[nums[i]] = i
        return [-1, -1]
