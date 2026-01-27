class Solution {
    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        int i = 0;
        HashSet<Pair> set = new HashSet<>();
        int res = 0;
        RollingHash rh = new RollingHash(s);
        rh.precompute();
        while(i < n){
            int j = i + 1;
            while(j < n && s.charAt(j) == (char)(s.charAt(j-1) != 'z' ? s.charAt(j-1) + 1 : 'a')){
                j++;
            }
            res += helper(i, j-1, set, rh);
            i = j;
        }
        return res;
    }

    public int helper(int start, int end, HashSet<Pair> set, RollingHash rh){
        int res = 0;
        for(int i = start; i <= Math.min(start + 25, end); i++){
            for(int j = i; j <= end; j++){
                Pair hash = rh.getHash(i, j);
                if(!set.contains(hash)){
                    res++;
                    set.add(hash);
                }
            }
        }
        return res;
    }
}

class Pair {
    long hash1, hash2;
    
    public Pair(long h1, long h2) {
        this.hash1 = h1;
        this.hash2 = h2;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair p = (Pair) o;
        return hash1 == p.hash1 && hash2 == p.hash2;
    }
    
    @Override
    public int hashCode() {
        return (int)(hash1 ^ hash2);
    }
}

class RollingHash {
    private static final long MOD1 = 1_000_000_007;
    private static final long MOD2 = 1_000_000_009;
    private static final long BASE = 31;
    
    private String str;
    private long[] prefixHash1, prefixHash2;
    private long[] basePow1, basePow2;
    private int n;
    
    public RollingHash(String s) {
        this.str = s;
        this.n = s.length();
        this.prefixHash1 = new long[n + 1];
        this.prefixHash2 = new long[n + 1];
        this.basePow1 = new long[n + 1];
        this.basePow2 = new long[n + 1];
    }
    
    public void precompute() {
        // Precompute powers
        basePow1[0] = 1;
        basePow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            basePow1[i] = (basePow1[i - 1] * BASE) % MOD1;
            basePow2[i] = (basePow2[i - 1] * BASE) % MOD2;
        }
        
        // Precompute prefix hashes
        prefixHash1[0] = 0;
        prefixHash2[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixHash1[i + 1] = (prefixHash1[i] * BASE + str.charAt(i)) % MOD1;
            prefixHash2[i + 1] = (prefixHash2[i] * BASE + str.charAt(i)) % MOD2;
        }
    }
    
    public Pair getHash(int start, int end) {
        int length = end - start + 1;
        
        long hash1 = (prefixHash1[end + 1] - (prefixHash1[start] * basePow1[length]) % MOD1 + MOD1) % MOD1;
        long hash2 = (prefixHash2[end + 1] - (prefixHash2[start] * basePow2[length]) % MOD2 + MOD2) % MOD2;
        
        return new Pair(hash1, hash2);
    }
    
    public int length() {
        return n;
    }
}