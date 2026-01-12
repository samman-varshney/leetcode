class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int dist = 0;
        for(int i=1; i<n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i-1][0];
            int y2 = points[i-1][1];

            int x = Math.abs(x1 - x2);
            int y = Math.abs(y1 - y2);

            dist += Math.min(x, y) + Math.abs(x-y);
        }
        return dist;
    }
}