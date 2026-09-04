class Solution:
    def firstStableIndex(self, nums: list[int], k: int) -> int:
        n = len(nums)
        right_min = [0] * n
        temp = 1000000001
        for i in range(n-1, -1, -1):
            temp = min(temp, nums[i])
            right_min[i] = temp

        
        temp = -1
        for i in range(0, n, 1):
            temp = max(temp, nums[i])
            score = temp - right_min[i]
            if score <= k:
                return i
        
        return -1
        

        