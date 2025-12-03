class Solution {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;

        // FIX: handle k = 0 early
        if (k == 0) {
            long sum = 0;
            for (int x : reward2) sum += x;
            return (int) sum;
        }

        long baseSum = 0;
        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            baseSum += reward2[i];
            gain[i] = reward1[i] - reward2[i];
        }

        if (k == n) {
            long ans = 0;
            for (int x : reward1) ans += x;
            return (int) ans;
        }

        int idx = n - k;
        int threshold = quickselect(gain, 0, n - 1, idx);

        long sum = baseSum;
        int picked = 0;

        for (int i = 0; i < n; i++) {
            if (gain[i] > threshold) {
                sum += gain[i];
                picked++;
            }
        }

        for (int i = 0; i < n && picked < k; i++) {
            if (gain[i] == threshold) {
                sum += gain[i];
                picked++;
            }
        }

        return (int) sum;
    }

    private int quickselect(int[] a, int left, int right, int k) {
        while (true) {
            int pivot = partition(a, left, right);
            if (pivot == k) return a[pivot];
            else if (pivot < k) left = pivot + 1;
            else right = pivot - 1;
        }
    }

    private int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (a[j] <= pivot) {
                int t = a[i]; a[i] = a[j]; a[j] = t;
                i++;
            }
        }

        int t = a[i]; a[i] = a[right]; a[right] = t;
        return i;
    }
}
