class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] treverse, int visit[] , int idx){
        treverse[idx] = 1;
        visit[idx] = 1;
        
        for(int i : adj.get(idx)){
            if(visit[i] == 0){
                if(treverse[i] == 0 && dfs(adj, treverse, visit, i))return true;
            }else
                return true;
        }
        visit[idx] = 0;
        return false;
    }
    public boolean canFinish(int n, int[][] pq) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pq.length; i++){
            adj.get(pq[i][0]).add(pq[i][1]);
        }
        int[] treverse = new int[n];
        int[] visit = new int[n];
        
        for(int i=0;i<n;i++){
            if(treverse[i] == 0)
                if(dfs(adj, treverse, visit, i))return false;
        }
        return true;
        
    }
}