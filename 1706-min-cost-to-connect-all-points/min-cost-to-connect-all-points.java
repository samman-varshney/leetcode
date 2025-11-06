class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist  = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] mst = new boolean[n];
        int totalcost  = 0;
        dist[0] = 0;

        for(int i=0; i<n; i++){
            int u = -1;
            for(int v=0; v<n; v++){
                if(!mst[v] && (u==-1 || dist[u] > dist[v])){
                    u = v;
                }
            }

            mst[u] = true;
            totalcost += dist[u];

            for(int v=0; v<n; v++){
                if(!mst[v]){
                    int cost = Math.abs(points[v][0] - points[u][0]) + Math.abs(points[v][1] - points[u][1]);
                    if(dist[v] > cost){
                        dist[v] = cost;
                    }
                }
            }
        }

        return totalcost;
    }
}