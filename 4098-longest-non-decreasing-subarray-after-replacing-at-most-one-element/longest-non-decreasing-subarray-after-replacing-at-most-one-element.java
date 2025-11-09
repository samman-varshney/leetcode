class Solution {
        public int longestSubarray(int[] A) {
        int n = A.length;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++)
            if (A[i - 1] <= A[i])
                left[i] = left[i - 1] + 1;
        for (int i = n - 2; i >= 0; i--)
            if (A[i] <= A[i + 1])
                right[i] = right[i + 1] + 1;
        int res = Math.min(n, Arrays.stream(left).max().getAsInt() + 1);
        for (int i = 1; i < n - 1; i++)
            if (A[i - 1] <= A[i + 1])
                res = Math.max(res, left[i - 1] + 1 + right[i + 1]);
        return res;
    }
}