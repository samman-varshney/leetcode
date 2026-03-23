class Solution {
    public int findMinArrowShots(int[][] segments) {
        Arrays.sort(segments, (a, b) -> Integer.compare(a[0], b[0]));

        int ans = 0, arrow = 0, n = segments.length;
        for (int i = n-1; i >= 0; i--) {
            if (ans == 0 || segments[i][1] < arrow) {
                ans ++;
                arrow = segments[i][0];
            }
        }
        return ans;
    }
}