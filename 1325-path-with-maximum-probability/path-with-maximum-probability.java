class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new double[]{edges[i][1], succProb[i]});
            adj.get(edges[i][1]).add(new double[]{edges[i][0], succProb[i]});
        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0],a[0]));
        pq.add(new double[]{1, start});
        double[] success = new double[n];
        success[start] = 1;
        while(!pq.isEmpty()){
            int node = (int)pq.peek()[1];
            double prob = pq.poll()[0];

            if(node == end)
                return prob;
            
            for(double[] x :adj.get(node)){
                int neighbor = (int)x[0];
                double nextProb = prob*x[1];
                if(success[neighbor] < nextProb){
                    success[neighbor] = nextProb;
                    pq.offer(new double[]{success[neighbor], neighbor});
                }
            }
        }
        return 0;
    }
}