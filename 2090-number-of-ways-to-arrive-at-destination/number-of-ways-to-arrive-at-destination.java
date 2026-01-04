class Tuple {
    int node;
    long time;
    Tuple(int node, long time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    int mod = (int)1e9 + 7;

    public int dfs(int node, List<List<Tuple>> adj, int[] dp, long[] dist) {
        if (node == dist.length - 1) return 1;
        if (dp[node] != -1) return dp[node];

        long ways = 0;
        for (Tuple nbr : adj.get(node)) {
            if (dist[node] + nbr.time == dist[nbr.node]) {
                ways = (ways + dfs(nbr.node, adj, dp, dist)) % mod;
            }
        }
        return dp[node] = (int) ways;
    }

    public int countPaths(int n, int[][] roads) {
        List<List<Tuple>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] r : roads) {
            adj.get(r[0]).add(new Tuple(r[1], r[2]));
            adj.get(r[1]).add(new Tuple(r[0], r[2]));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Tuple> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        pq.add(new Tuple(0, 0));

        while (!pq.isEmpty()) {
            Tuple t = pq.poll();
            if (t.time > dist[t.node]) continue;

            for (Tuple nbr : adj.get(t.node)) {
                long nt = t.time + nbr.time;
                if (nt < dist[nbr.node]) {
                    dist[nbr.node] = nt;
                    pq.add(new Tuple(nbr.node, nt));
                }
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return dfs(0, adj, dp, dist);
    }
}
