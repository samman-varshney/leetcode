class Tuple{
    int num, cost;
    public Tuple(int num, int cost){
        this.num = num;
        this.cost = cost;
    }
}
class Solution {

    public boolean isPrime(int n){
        if(n <= 1)
            return false;

        for(int i=2; i*i<=n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public int minOperations(int n, int m) {
        if(isPrime(n) || isPrime(m)){
            return -1;
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b)->(a.cost - b.cost));
        pq.add(new Tuple(n, n));

        int[] dist = new int[10000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = n;

        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            if(t.num == m){
                return t.cost;
            }

            if(t.cost > dist[t.num])continue;

            for(int i=1; i<=n; i*=10){
                int digit = (t.num/i)%10;
                //increase 
                if(digit < 9){
                    int num = t.num + i;
                    int cost = t.cost + num;
                    if(!isPrime(num) && dist[num] > cost){
                        dist[num] = cost;
                        pq.add(new Tuple(num, cost));
                    }
                }
                //decrease
                if(digit > 0){
                    int num = t.num - i;
                    int cost = t.cost + num;
                    if(!isPrime(num) && dist[num] > cost && num >= i){
                        dist[num] = cost;
                        pq.add(new Tuple(num, cost));
                    }
                }
                
            }
        }
        return -1;
    }
}