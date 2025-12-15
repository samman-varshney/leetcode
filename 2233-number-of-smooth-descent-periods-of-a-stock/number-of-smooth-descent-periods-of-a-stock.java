class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long res = 0;
        long count = 0;
        for(int i=0; i<n; i++){
                if(i==0 || prices[i] + 1 == prices[i-1]){
                    count++;
                }else{
                    res += (count*(count+1))/2;
                    count = 1;
                }
        } 
        res += (count*(count+1))/2;
        return res;
    }
}