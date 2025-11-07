class Solution {
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