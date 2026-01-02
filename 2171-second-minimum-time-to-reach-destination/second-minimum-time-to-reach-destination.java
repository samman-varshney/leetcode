class Pair{
    int node, time;
    public Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0], v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist1 = new int[n+1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        dist1[1] = 0;

        int[] dist2 = new int[n+1];
        Arrays.fill(dist2, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)->(a.time - b.time));
        pq.add(new Pair(1, 0));
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            
            if(dist2[p.node] < p.time){
                continue;
            }

            if(p.node == n && p.time == dist2[p.node]){
                return p.time;
            }
            
            int newTime = p.time;
            if((newTime/change)%2 == 1){
                    newTime = (newTime/change+1)*change;
                }

            for(int nbrs: adj.get(p.node)){
                
                int leaveTime = newTime+time;
                
                if(leaveTime < dist1[nbrs]){
                    dist2[nbrs] = dist1[nbrs];
                    dist1[nbrs] = leaveTime;
                    pq.add(new Pair(nbrs, leaveTime));
                }else if (leaveTime > dist1[nbrs] && leaveTime < dist2[nbrs]){
                    dist2[nbrs] = leaveTime;
                    pq.add(new Pair(nbrs, leaveTime));
                }
            }
        }
        return  dist2[n];
    }
}