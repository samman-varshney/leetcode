class Solution {
    public int maximumAND(int[] nums, int k, int m) {
        int res = 0;

        for (int bit = 30; bit >= 0; bit--) {
            int candidate = res | (1 << bit);
            long[] cost = new long[nums.length];

            for (int i = 0; i < nums.length; i++) {
                cost[i] = getCost(nums[i], candidate);
            }

            Arrays.sort(cost);

            long total = 0;
            for (int i = 0; i < m; i++) {
                total += cost[i];
            }

            if (total <= k) {
                res = candidate;
            }
        }

        return res;
    }

    private long getCost(int a, int target) {
        int y = a;

        for (int bit = 30; bit >= 0; bit--) {
            if (((target >> bit) & 1) == 1 && ((y >> bit) & 1) == 0) {
                y = ((y >> bit) + 1) << bit;
            }
        }

        return (long) y - a;
    }
}
