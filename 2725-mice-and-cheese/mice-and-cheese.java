class Solution {
    public int miceAndCheese(int[] r1, int[] r2, int k) {
        int n = r1.length;
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = r1[i];
            arr[i][1] = r1[i] - r2[i]; // diff
        }

        Arrays.sort(arr, (a, b) -> b[1] - a[1]); // sort by diff descending

        int sum = 0;

        // give the first k items to mouse 1
        for (int i = 0; i < k; i++) {
            sum += arr[i][0];
        }

        // remaining to mouse 2
        for (int i = k; i < n; i++) {
            sum += (arr[i][0] - arr[i][1]);
        }

        return sum;
    }
}
