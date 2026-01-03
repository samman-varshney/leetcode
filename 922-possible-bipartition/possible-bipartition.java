class Solution {
    boolean dfs(int node, int color, List<List<Integer>> adj, int[] colors){
        colors[node] = color;

        for(int nbrs: adj.get(node)){

            if(colors[nbrs] == color || (colors[nbrs]==-1 && !dfs(nbrs, color^1, adj, colors))){
                return false;
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] dislike: dislikes){
            int u = dislike[0];
            int v = dislike[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1);

        for(int i=1; i<=n; i++){
            if(colors[i] == -1 && !dfs(i, 0, adj, colors)){
                return false;
            }
        }
        return true;
    }
}