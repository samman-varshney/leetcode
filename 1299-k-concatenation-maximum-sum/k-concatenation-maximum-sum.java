class Solution {
    public int kConcatenationMaxSum(int[] nums, int k) {
        int mod = (int)1e9 + 7;
        int n = nums.length;

        // total sum
        long totalSum = 0;
        for (int x : nums) totalSum += x;

        // max prefix sum
        long prefix = 0, forward = 0;
        for (int x : nums) {
            prefix += x;
            forward = Math.max(forward, prefix);
        }

        // max suffix sum
        long suffix = 0, backward = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffix += nums[i];
            backward = Math.max(backward, suffix);
        }

        // Kadane
        long curr = 0, linear = 0;
        for (int x : nums) {
            curr = Math.max(x, curr + x);
            linear = Math.max(linear, curr);
        }

        if (k == 1) return (int)(linear % mod);

        if (totalSum > 0) {
            long ans = forward + backward + (k - 2) * totalSum;
            return (int)(ans % mod);
        }

        return (int)(Math.max(linear, forward + backward) % mod);
    }
}
