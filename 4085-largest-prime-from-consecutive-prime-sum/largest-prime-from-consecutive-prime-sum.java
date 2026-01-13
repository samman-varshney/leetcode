class Solution {
    public int largestPrime(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        for(int i=2; i<=n; i++){
            if(!primes[i])continue;
            for(int j=2; j*i<=n; j++){
                primes[i*j] = false; 
            }
        }
        int sum = 0;
        int max =0;
        for(int i=2; i<=n; i++){
            if(primes[i]){
                sum += i;
            }
            if(sum > n){
                break;
            }
            if(primes[sum]){
                max = sum;
            }
            
        }
        return max;
    }
}