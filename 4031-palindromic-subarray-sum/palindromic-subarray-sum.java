class Solution {
    public long getSum(int[] nums) {
        int n = nums.length;
        int[] modified = new int[2 * n + 3];

        modified[0] = -2;
        modified[2 * n + 2] = -3;
        modified[2 * n + 1] = -1;
        long[] prefix = new long[2*n+4];

        int k = 0;
        for (int i = 1; i <= 2 * n; i += 2) {
            modified[i] = -1;
            modified[i + 1] = nums[k];
            prefix[i+1] = prefix[i];
            prefix[i+2] = prefix[i+1] + nums[k++]; 
        }

        prefix[2*n+2] = prefix[2*n+3] = prefix[2*n+1];

        int[] p = new int[2 * n + 3];
        int l = 0, r = 1;
        long result = 0;
        for (int i = 1; i <= 2 * n + 1; i++) {

            if (i < r) {
                p[i] = Math.min(p[l + (r - i)], r - i - 1);
            }

            while ((i + p[i] + 1 < 2 * n + 3) &&
                    (i - p[i] - 1 >= 0) &&
                    (modified[i + p[i] + 1] == modified[i - p[i] - 1])) 
            {
                p[i]++;
            }

            result = Math.max(result, prefix[i+p[i] + 1] - prefix[i - p[i]]);

            if (i + p[i] > r) {
                l = i - p[i] - 1;
                r = i + p[i] + 1;
            }
        }
        return result;
    }
}