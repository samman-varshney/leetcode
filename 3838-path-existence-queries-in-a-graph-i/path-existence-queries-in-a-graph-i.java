class Solution {
    int[] parent;
    int[] size;

    void union(int u, int v){
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

    int find(int u){
        if(parent[u] == u){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        size = new int[n];
        for(int i =0; i<n; i++){
            parent[i ] =i;
            size[i] = 1;
        }
        int[][] dummy = new int[n][2];
        for(int i=0; i<n; i++){
            dummy[i][0] = i;
            dummy[i][1] = nums[i];
        }
        Arrays.sort(dummy, (a, b)->(a[1] - b[1]));
        int j = n-2;
        for(int i=n-1; i>=0; i--){
            while(j>=0 && Math.abs(nums[i] - nums[j]) <= maxDiff){
                union(i, j);
                j--;
            }
        }
        int m = queries.length;
        boolean[] res = new boolean[m];
        for(int i=0; i<m; i++){
            res[i] = find(queries[i][0]) == find(queries[i][1]);
        }
        return res;
    }

}