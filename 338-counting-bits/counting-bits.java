class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0; i<=n; i++){
            int cnt = 0;
            for(int j=0; j<32; j++){
                cnt += ((i>>j)&1);
            }
            res[i] = cnt;
        }
        return res;
    }
}