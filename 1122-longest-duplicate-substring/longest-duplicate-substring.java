class Pair{
    int start, end;
    public Pair(int start, int end ){
        this.start = start;
        this.end = end;
    }
}

class Solution {
    long[] base, invbase, hash;
    int mod = (int)1e9+7;
    long prime = 31;
    long invPrime = 129032259L;

    public Pair helper(int mid, String s){
        int n = s.length();
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i=0; i<=n - mid; i++){
            long hashcode = (((hash[i + mid] - hash[i] + mod)%mod)*invbase[i])%mod;
            if(map.containsKey(hashcode) && 
            s.substring(i, i+mid).equals(s.substring(map.get(hashcode), map.get(hashcode)+mid))){
                return new Pair(i, i+mid);
            }
            map.put(hashcode, i);
        }
        return null;
    }

    public String longestDupSubstring(String s) {
        int n = s.length();
        base = new long[n+1];
        invbase = new long[n+1];
        hash = new long[n+1];

        base[0] = 1;
        for(int i=1; i<=n; i++){
            base[i] = (base[i-1]*prime)%mod;
        }

        invbase[0] = 1;
        for(int i=1; i<=n; i++){
            invbase[i] = (invbase[i-1]*invPrime)%mod;
        }

        for(int i=0; i<n; i++){
            hash[i+1] = (hash[i] + (s.charAt(i) * base[i])%mod)%mod;
        }
        Pair res = null;
        int start = 0, end = n-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            Pair p = helper(mid, s);
            if(p != null){
                start = mid+1;
                res = p;
            }else{
                end = mid-1; 
            }
        }

        if(res == null){
            return "";
        }
        return s.substring(res.start, res.end);
    }
}