class Solution {
    int mod = (int)1e9+7;

    public int modFact(int num){
        long res = 1;
        for(int i=1; i<=num; i++){
            res = (res*i)%mod;
        }
        return (int)res;
    }
    
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int root = complexity[0];
        int minComplexity = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            minComplexity = Math.min(minComplexity, complexity[i]);
        }

        if(minComplexity <= root){
            return 0;
        }

        return modFact(n-1);
    }
}