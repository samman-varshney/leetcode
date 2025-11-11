class SummaryRanges {
    int[] parent;
    TreeMap<Integer, Integer> ranges;
    private void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv)return;
        parent[pv] = pu;
    }
    private int find(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = find(parent[u]);
    }
    private void merge(int u, int v){
        if(u == -1 || v == 10001|| parent[u]==-1 || parent[v]==-1)return;

        ranges.put(find(u), ranges.get(find(v)));
        ranges.remove(find(v));
        union(u, v);
    }
    public SummaryRanges() {
        parent = new int[10002];
        Arrays.fill(parent, -1);
        ranges = new TreeMap<>();
    }
    
    public void addNum(int value) {
        if(parent[value]!=-1)return;
        parent[value] = value;
        ranges.put(value, value);
        
        merge(value-1, value);
        merge(value, value+1);
    }
    
    public int[][] getIntervals(){
        int n = ranges.size();
        int[][] res = new int[n][2];
        int i = 0;
        for(int key: ranges.keySet()){
            res[i][0] = key;
            res[i][1] = ranges.get(key);
            i++;
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */