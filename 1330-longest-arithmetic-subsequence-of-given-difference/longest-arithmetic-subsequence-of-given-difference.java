class Solution {
    public int longestSubsequence(int[] nums, int diff) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=n-1; i>=0; i--){
            int j = map.getOrDefault(nums[i]+diff, -1);
            if(j != -1){
                dp[i] = dp[j]+1;
            }
            map.put(nums[i], i);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}