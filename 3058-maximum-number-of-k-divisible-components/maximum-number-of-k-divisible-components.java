class Pair{
    int split;
    long value;

    Pair(int split, long value){
        this.split = split;
        this.value = value;
    }
}
class Solution {
    List<List<Integer>> adj;
    int[] values;
    int k;
    public Pair helper(int node, int parent){
        
        long value = values[node];
        int split = 0;
        for(int child : adj.get(node)){
            if(child == parent)continue;
            Pair p = helper(child, node);
            value += p.value;
            split += p.split;
        }

        if(value%k == 0){
            return new Pair(split+1, 0);
        }
        return new Pair(split, value);
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        this.values = values;
        this.k = k;

        Pair p = helper(0, -1);
        
        if(p.value == 0){
            return p.split;
        }
        return 0;
    }
}