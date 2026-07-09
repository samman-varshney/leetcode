class Solution {
    int[] parent, size;

    public int find(int u){
        if(parent[u] == u)
            return u;
        return parent[u] = find(parent[u]);
    }

    public void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv)return;
        if(size[pu] > size[pv]){
            size[pu] += size[pv];
            parent[pv] = pu;
        }else{
            size[pv] += size[pu];
            parent[pu] = pv;
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        int l = 0, r = 0;
        while(l < n){
            while(r < n && nums[l] + maxDiff >= nums[r])
                r++;
            
            for(int i=l+1; i<r; i++){
                union(l, i);
            }

            l = Math.max(l+1, r-1);
            r = l;
        }

        boolean[] result = new boolean[queries.length];
        for(int i=0; i<queries.length; i++){
            int[] q = queries[i];
            result[i] = find(q[0]) == find(q[1]);
        }

        return result;
    }
}