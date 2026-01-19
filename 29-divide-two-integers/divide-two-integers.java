class Solution {
    public int divide(int dividend, int divisor) {
        long res = 0;
        long n = Math.abs(1L*dividend), d = Math.abs(1L*divisor);
        for(int i=31; i>=0; i--){
            if(d<<i <= n){
                n -= d<<i;
                res+=1L<<i;
            }
        }
        if((dividend>=0 && divisor<0)||(dividend<0 && divisor>=0))
            return (int)-res;
        return (int)Math.min(Integer.MAX_VALUE, res);
    }
}