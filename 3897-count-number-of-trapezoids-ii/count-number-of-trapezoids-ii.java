class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        HashMap<Double, HashMap<Double, Integer>> slope  = new HashMap<>();
        HashMap<Integer, HashMap<Double, Integer>> mid = new HashMap<>();

        double inf = 1e9+7;

        for(int i=0; i<n; i++){
            int x1 = points[i][0], y1 = points[i][1];
            for(int j=i+1; j<n; j++){
                int x2 = points[j][0], y2 = points[j][1];

                double m, c;

                if(x1 == x2){
                    m = inf;
                    c = x1;
                }else{
                    m = (1.0*(y2 - y1))/(x2 - x1);
                    c = (1.0*(y1*x2 - x1*y2))/(x2 - x1);
                }

                if(m == -0.0)
                    m = 0.0;
                if(c == -0.0)
                    c = 0.0;


                int midpoint = (x1+x2)*10000 + (y1+y2);
                
                HashMap<Double, Integer> intercept = slope.computeIfAbsent(m, s -> new HashMap<>());
                intercept.put(c, intercept.getOrDefault(c, 0)+1);

                HashMap<Double, Integer> k = mid.computeIfAbsent(midpoint, s-> new HashMap<>());
                k.put(m, k.getOrDefault(m, 0)+1);
            }
        }

        int ans = 0;

        for(HashMap<Double, Integer> map : slope.values()){

            int sum = 0;
            for(int count: map.values()){
                ans += sum * count;
                sum += count;
            }
        }

        for(HashMap<Double, Integer> map : mid.values()){
            int sum = 0;
            for(int count: map.values()){
                ans -= sum * count;
                sum += count;
            }
        }

        return ans;
    }
}