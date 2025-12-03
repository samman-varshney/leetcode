class Solution {
    public long GCD(long a, long b){
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long LCM(long a, long b){
        return a*1L*b/GCD(a, b);
    }
    public long inclusion(long num, int a, int b, int c){
        return num/a + num/b + num/c - num/LCM(a, b) - num/LCM(b, c) - num/LCM(a, c) + num/LCM(a, LCM(b, c));
    }
  
    public int nthUglyNumber(int n, int a, int b, int c) {
        long start = 1, end = 2000000000;
        while(start <= end){
            long mid = start + (end - start)/2;
            long cnt = inclusion(mid, a, b, c);
            if(cnt >= n){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return (int)start;
    }
}