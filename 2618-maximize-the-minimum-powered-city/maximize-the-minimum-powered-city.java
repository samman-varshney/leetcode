class Solution {
    public boolean possible(long[] prefix, long min, int k, int r) {

        int n = prefix.length - 1;
        long[] meta = new long[n + 1];

        for (int i = 0; i < n; i++) {
            if (i + r + 1 <= n) {
                meta[i + r + 1] = meta[i + r];
            }

            long power = prefix[Math.min(n, i + r + 1)] - prefix[Math.max(0, i - r)] +
                    meta[Math.min(n, i + r + 1)] - meta[Math.max(0, i - r)];

            if (power + k < min) {
                return false;
            } else if (power < min) {
                long diff = min - power;
                meta[Math.min(n, i + r + 1)] += diff;
                k -= diff;
            }
        }
        return true;
    }

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long start = Integer.MAX_VALUE, end = k;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stations[i];
            start = Math.min(start, stations[i]);
        }
        end += prefix[n];
        //System.out.println(Arrays.toString(prefix));
        while (start <= end) {
            long mid = start + (end - start) / 2;
            if (possible(prefix, mid, k, r)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}