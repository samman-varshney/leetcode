class Solution {
        public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.computeIfAbsent(
                e[0], m -> new HashMap<>()
            ).compute(
                  
                e[1], (k, v) -> v == null || v > e[2] ? e[2] : v
            );
            graph.computeIfAbsent(
                e[1], m -> new HashMap<>()
            ).compute(
                e[0], (k, v) -> v == null || v > e[2] ? e[2] : v
            );
        } 
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[2]);
        while (!pq.isEmpty()) {
            int[] timeNode = pq.poll();
            int time = timeNode[0], u = timeNode[1];
            if (ans[u] == -1 || ans[u] > time) {
                ans[u] = time;
                if (graph.containsKey(u)) {
                    for (var nodeTime : graph.remove(u).entrySet()) {
                        int v = nodeTime.getKey(), w = nodeTime.getValue();
                        if (time + w < disappear[v]) {
                            pq.offer(new int[]{time + w, v});
                        }
                    }
                }
            }
        }
        return ans;
    }
}