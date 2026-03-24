class Solution {
    int[] parent;
    int find(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    void union(int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv)return;
        parent[pu] = pv;
    }

    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b)->{
            return a[1]-b[1];
        });
        int limit = 2*events[n-1][1];
        
        parent = new int[limit];
        for(int i=0; i<limit; i++){
            parent[i] = i;
        }
        
        int attend = 0;
        for(int[] ent: events){
            int day = find(ent[0]);
            if(day <= ent[1]){
                attend++;
                union(day, day+1);
            }
        }
        return attend;
    }
}