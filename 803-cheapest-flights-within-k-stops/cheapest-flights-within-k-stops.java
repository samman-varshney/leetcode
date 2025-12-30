class Pair{
    int city;
    int price;

    public Pair(int city, int price){
        this.city = city;
        this.price = price;
    }
}
class Solution {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<>());
        
        for(int[] f: flights){
            adj.get(f[0]).add(new Pair(f[1], f[2]));
        }

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(src, 0));
        k++;
        while(!pq.isEmpty() && k>0){
            int size = pq.size();
            while(size-- >0){

                Pair p = pq.poll();
                
                for(Pair nbrs: adj.get(p.city)){
                    if(prices[nbrs.city] > p.price + nbrs.price){
                        prices[nbrs.city] = p.price + nbrs.price;
                        pq.add(new Pair(nbrs.city, prices[nbrs.city]));
                    }
                }
            }
            k--;
        }
        return prices[dst]==Integer.MAX_VALUE?-1:prices[dst];
    }
}