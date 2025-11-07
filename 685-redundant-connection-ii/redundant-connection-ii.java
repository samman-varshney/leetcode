class Solution {


        public boolean isSingleComponent(int n, int idx, int[][] edges) {
        // Step 1: Build adjacency list (undirected view)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i=0; i<n; i++) {
            if(i == idx)continue;
            int[] e = edges[i];
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected connection
        }

        // Step 2: BFS or DFS from node 1
        boolean[] vis = new boolean[n + 1];
        int[] indegree = new int[n+1];
        for(int i=0; i<n; i++){
            if(i == idx)continue;
            indegree[edges[i][1]]++;
        }

        //check if all ones 
        int root = -1;
        for(int i=1; i<=n; i++){
            if(indegree[i]==0){
                root = i;
                break;
            }
        }
        dfs(root, graph, vis);

        // Step 3: Check if all nodes are visited
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) return false; // disconnected component found
        }
        return true;
    }

    private void dfs(int node, List<List<Integer>> graph, boolean[] vis) {
        vis[node] = true;
        for (int nei : graph.get(node)) {
            if (!vis[nei]) dfs(nei, graph, vis);
        }
    }


    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        int[] indegree = new int[n+1];
        for(int i=0; i<n; i++){
            indegree[edges[i][1]]++;
        }

        //check if all ones 
        boolean allOnes = true;
        for(int i=1; i<=n; i++){
            if(indegree[i]!=1){
                allOnes = false;
                break;
            }
        }
        // System.out.println(Arrays.toString(indegree));
        if(allOnes){
            // System.out.println("in all ones");
            redundent r = new redundent();
            return r.findRedundantConnection(edges);
        }

        //get node with indegree as 2
        int node = -1;
        for(int i=1; i<=n; i++){
            if(indegree[i]==2){
                node = i;
                break;
            }
        }
        int cnt = 0;
        for(int i=n-1; i>=0; i--){
            if(edges[i][1] == node ){
                if(cnt == 1)
                    return edges[i];
                if(isSingleComponent(n, i, edges)){
                    return edges[i];
                }
                cnt++;
            }
        }

        return new int[]{-1, -1};
    }
}

class redundent {
    int[] parent, size;
       void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv)return;
        else if(size[pu] > size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        }else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
    int find(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0; i<n; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(find(u) == find(v)){
                return edges[i];
            }

            union(u, v);
        }
        return new int[]{-1, -1};
    }
}


// 0 1 2
// [0, 1, 2]
// [1, 2, 3]