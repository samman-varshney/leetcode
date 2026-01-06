class Solution {
    public int tribonacci(int n) {
        if(n <= 2){
            return n>0?1:0;
        }
        int a0 = 0, a1 = 1, a2 = 1;
        int an;
        for(int i=0; i<n-2; i++){
            int temp = a0 + a2 + a1;
            a0 = a1;
            a1 = a2;
            a2 = temp;
        }
        return a2;
    }
}