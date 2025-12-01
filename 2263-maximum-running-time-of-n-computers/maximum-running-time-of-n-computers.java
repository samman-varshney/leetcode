class Solution {
    public boolean possible(int n, long m, int[] bts){
        long sum = n*m;
        for(int x : bts){
            sum -= Math.min(x, m);
            if(sum <= 0){
                return true;
            }
        }
        return false;
    }
    public long maxRunTime(int n, int[] bts) {
        long sum = 0;
        for(int x : bts){
            sum += x;
        }

        long start = 0, end = (sum+n-1)/n;
        while(start <= end){
            long mid = start + (end -start)/2;
            if(possible(n, mid, bts)){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }
}