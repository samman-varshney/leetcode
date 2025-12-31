class Solution {

    public boolean dfs(int node, List<List<Integer>> adj, int[] visited, int dest){
        if(node == dest)
            return true;
        visited[node] = 1;

        for(int child : adj.get(node)){
            if(visited[child]  == 0){
                boolean res = dfs(child, adj, visited, dest);
                if(res)return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];
        return dfs(source, adj, visited, destination);
    }
}