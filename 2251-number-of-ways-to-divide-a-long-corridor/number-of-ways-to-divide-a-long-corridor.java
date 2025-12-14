class Solution {
    public int numberOfWays(String s) {
        int n = s.length();
        int count = 0;
        int mod = 1000000007;
        int i=0; 
        long p = 1;
        long res = 1;
        while(i < n){

            int cnt = 0;
            while(i<n && cnt <2){
                if(s.charAt(i) == 'S'){
                    cnt++;
                    count++;
                }
                i++;
            }
            res = (res*p)%mod;
            p = 1;
            while(i<n && s.charAt(i) != 'S'){
                i++;
                p++;
            }
        }
        if(count == 0 || count%2 == 1){
            return 0;
        }
        return (int)res;
    }
}