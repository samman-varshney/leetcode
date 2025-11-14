class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] res = new int[n][n];

        for(int[] query : queries){
            for(int i=query[0]; i<=query[2]; i++){
                res[i][query[1]] += 1;
                if(query[3]+1 < n){
                    res[i][query[3]+1] -= 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            int prev = 0;
            for(int j=0; j<n; j++){
                res[i][j] += prev;
                prev = res[i][j];
            }
        }
        return res;
    }
}