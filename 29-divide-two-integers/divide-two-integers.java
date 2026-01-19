class Solution {
    public int divide(int dividend, int divisor) {
        long d = Math.abs(1L*divisor), n = Math.abs(1L*dividend);
        // System.out.println(n);
        long start = 0, end = n;
        while(start <= end){
            long mid = start + (end-start)/2;
            if(d*mid <= n){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        // System.out.println(end);

        if((dividend >=0 && divisor < 0) || (dividend < 0 && divisor >= 0)){
            // System.out.println("in the condition");
            return (int)-end;
        }
        return (int)Math.min(end, Integer.MAX_VALUE);
    }
}