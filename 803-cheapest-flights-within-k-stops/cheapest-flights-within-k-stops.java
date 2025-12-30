class Triplet {
    int city;
    int price;
    int stops;

    public Triplet(int city, int price, int stops) {
        this.city = city;
        this.price = price;
        this.stops = stops;
    }
}

class Pair {
    int city;
    int price;

    public Pair(int city, int price) {
        this.city = city;
        this.price = price;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] f : flights) {
            adj.get(f[0]).add(new Pair(f[1], f[2]));
        }

        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<Triplet> pq =
                new PriorityQueue<>((a, b) -> a.price - b.price);

        pq.add(new Triplet(src, 0, 0));
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            Triplet cur = pq.poll();

            if (cur.city == dst) return cur.price;

            if (cur.stops == k + 1) continue;

            for (Pair nbr : adj.get(cur.city)) {
                int newCost = cur.price + nbr.price;
                int newStops = cur.stops + 1;

                if (newCost < dist[nbr.city][newStops]) {
                    dist[nbr.city][newStops] = newCost;
                    pq.add(new Triplet(nbr.city, newCost, newStops));
                }
            }
        }

        return -1;
    }
}
