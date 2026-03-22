class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] prefix = new int[1001];
        Arrays.sort(trips, (a, b)->{
            if(a[0]!=b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        for(int i=0; i<n; i++){
            int from = trips[i][1];
            int to = trips[i][2];

            prefix[from] += trips[i][0];
            prefix[to] -= trips[i][0];
        }
        int cap =0 ;
        for(int i=0; i<1001; i++){
            cap += prefix[i];
            if(cap > capacity)
                return false;
        }
        return true;
    }
}