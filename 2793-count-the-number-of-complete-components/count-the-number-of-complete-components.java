class Solution {
    int[] parent, size;
    int find(int u){
        if(parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }

    void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv)return;
        if(size[pv] > size[pu]){
            size[pv] += size[pu];
            parent[pu] = pv;
        }else{
            size[pu] += size[pv];
            parent[pv] = pu;
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            union(u, v);
        }
        // System.out.println(Arrays.toString(size));
        // System.out.println(Arrays.toString(parent));
        int[] covered = new int[n];
        int count = 0;
        for(int i=0; i<n; i++){
            int u = find(i);
            if(covered[u] == 1)continue;
            covered[u] = 1;
            int edgeCount = 0;
            for(int[] edge: edges){
                if(find(edge[0]) == u){
                    edgeCount++;
                }
            }
            //System.out.println(edgeCount);
            // for a complete graph the number of edges are n * (n - 1)/2

            if(edgeCount == size[u] * (size[u] - 1)/2)
                count++;
        }

        return count;
    }
}