class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int mod = (int)1e9+7;

        long[] map = new long[1000000];
        long left[] = new long[n];

        for(int i=0; i<n; i++){
            left[i] = map[nums[i]*2];
            map[nums[i]]++;
        } 

        map = new long[1000000];
        long res = 0;

        for(int i=n-1; i>=0; i--){
            res = (res + left[i] * map[nums[i]*2])%mod;
            map[nums[i]]++;
        }

        return (int)res;
    }
}