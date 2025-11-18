class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        long[] cache = new long[n];
        cache[0] = 1;
        int[] index = new int[m];

        for(int j=1; j<n; j++){
            long[] next = new long[m];
            long min = Long.MAX_VALUE;
            for(int i=0; i<m; i++){
                next[i] = cache[index[i]]*primes[i];
                min = Math.min(min, next[i]);
            }

            
            cache[j] = min;
            for(int i=0; i<m; i++){
                if(min == next[i])index[i]++;
            }
           
        }

        return (int)cache[n-1];
    }
}
