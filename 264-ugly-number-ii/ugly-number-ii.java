class Solution {
    public int nthUglyNumber(int n) {
        int[] cache = new int[n];
        cache[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for(int i=1; i<n; i++){
            int next2 = cache[p2]*2;
            int next3 = cache[p3]*3;
            int next5 = cache[p5]*5;

            int temp = Math.min(next2, Math.min(next3, next5));
            cache[i] = temp;
            if(temp == next2)p2++;
            if(temp == next3)p3++;
            if(temp == next5)p5++;
        }

        return cache[n-1];
    }
}