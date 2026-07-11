class Solution {
    int[] parent, size, edge;
    int find(int u){
        if(parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }

    void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv){
            edge[pu]++;
            return;
        }
        if(size[pv] > size[pu]){
            size[pv] += size[pu];
            parent[pu] = pv;
            edge[pv] += edge[pu] + 1;
        }else{
            size[pu] += size[pv];
            parent[pv] = pu;
            edge[pu] += edge[pv] + 1;
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        edge = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] ed: edges){
            int u = ed[0];
            int v = ed[1];

            union(u, v);
        }

        
        int count = 0;
        for(int i=0; i<n; i++){
            
            if(find(i) != i)continue;

            if(edge[i] == size[i] * (size[i] - 1)/2)
                count++;
        }

        return count;
    }
}