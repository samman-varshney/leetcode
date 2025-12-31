class Triplet{
    String currency;
    double rate;
    int day;

    public Triplet(String currency, double rate, int day){
        this.currency = currency;
        this.rate = rate;
        this.day = day;
    }
}
class Solution {

    double res;
    String initialCurrency;

    public void dfs(String currency, int day, HashMap<String, List<Triplet>> adj, double amt, HashSet<String> visited){
        
        if(currency.equals(initialCurrency)){
            res = Math.max(res, amt);
        }
        String curr = currency+" "+day;
        visited.add(curr);

        for(Triplet nbrs: adj.get(currency)){
            String key = nbrs.currency+" "+nbrs.day;
            if(!visited.contains(key) && nbrs.day >= day){
                dfs(nbrs.currency, nbrs.day, adj, amt*nbrs.rate, visited);
            }
        }
        visited.remove(curr);
    }



    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        HashMap<String, List<Triplet>> adj = new HashMap<>();

        //day 1
        for(int i=0; i<pairs1.size(); i++){

            String start = pairs1.get(i).get(0);
            String target = pairs1.get(i).get(1);
            double rate = rates1[i];

            adj.computeIfAbsent(start, k->new ArrayList<>()).add(new Triplet(target, rate, 1));
            adj.computeIfAbsent(target, k->new ArrayList<>()).add(new Triplet(start, 1/rate, 1));
        }

        //day 2
         for(int i=0; i<pairs2.size(); i++){

            String start = pairs2.get(i).get(0);
            String target = pairs2.get(i).get(1);
            double rate = rates2[i];

            adj.computeIfAbsent(start, k->new ArrayList<>()).add(new Triplet(target, rate, 2));
            adj.computeIfAbsent(target, k->new ArrayList<>()).add(new Triplet(start, 1/rate, 2));
        }

        this.res = 1.0;
        this.initialCurrency = initialCurrency;

        HashSet<String> visited = new HashSet<>();
        dfs(initialCurrency, 1, adj, 1.0, visited);

        return res;
    }
}