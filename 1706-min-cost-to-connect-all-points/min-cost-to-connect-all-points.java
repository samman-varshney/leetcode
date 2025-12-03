class DisjointSet{
    int[] parent, size;
    DisjointSet(int n){
        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    void union(int u, int v){
        int pv = find(v);
        int pu = find(u);

        if(pu == pv)return;
        else if(size[pv] > size[pu]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
    int find(int u){
        if(parent[u] == u){
            return u;
        }
        return parent[u] = find(parent[u]);
    }

}
class Pair{
    int wt, curr, parent;
    Pair(int wt, int curr, int parent){
        this.wt = wt;
        this.curr = curr;
        this.parent = parent;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<Pair> edges = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j)continue;

                int dist = Math.abs(points[i][0] - points[j][0])+ Math.abs(points[i][1] - points[j][1]);
                edges.add(new Pair(dist, j, i));
            }
        }
        Collections.sort(edges, (a, b)->(a.wt-b.wt));

        DisjointSet d = new DisjointSet(n);
        int totalcost = 0;
        for(Pair p : edges){
            int wt = p.wt;
            int u = p.curr;
            int v = p.parent;

            if(d.find(u) != d.find(v)){
                d.union(u, v);
                totalcost+=wt;
            }
        }   

        return totalcost;
    }
}