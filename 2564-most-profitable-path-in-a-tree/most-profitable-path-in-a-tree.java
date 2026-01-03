class Solution {

    int dfs1(int node, int parent, int alice, List<List<Integer>> adj, int bob, int[] amount){
        if(node == bob){
            if(node != 0){
                amount[node] = 0;
            }else{
                amount[node] /= 2;
            }
            return 1;
        }

        for(int nbrs: adj.get(node)){
            if(nbrs == parent)continue;

            int res = dfs1(nbrs, node, alice+1, adj, bob, amount);
            if(res != -1){
                res++;
                if(res < alice){
                    amount[node] = 0;
                }else if(res == alice){
                    amount[node] /= 2;
                }
                return res;
            }
        }
        return -1;
    }

    long dfs2(int node, int parent, List<List<Integer>> adj, int[] amount){
        long max = Long.MIN_VALUE;
        for(int nbrs: adj.get(node)){
            if(nbrs == parent)continue;
            long res = dfs2(nbrs, node, adj, amount);
            max  = Math.max(res, max);
        }
        return amount[node]+(max == Long.MIN_VALUE?0:max);
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //changing amount array according to bob path
        dfs1(0, -1, 1, adj, bob, amount);
        // System.out.println(Arrays.toString(amount));
        //getting max Score for alice path
        long res = dfs2(0, -1, adj, amount);
        // System.out.println(res);
        return (int)res;

    }
}