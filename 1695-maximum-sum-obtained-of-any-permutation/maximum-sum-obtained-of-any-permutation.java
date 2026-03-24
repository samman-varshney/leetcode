class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        for(int[] req: requests){
            prefix[req[0]] += 1;
            prefix[req[1]+1] -= 1;
        }

        for(int i=1; i<=n; i++){
            prefix[i] += prefix[i-1];
        }

        Arrays.sort(nums);
        Arrays.sort(prefix);

        long res = 0;
        int mod = (int)1e9+7;
        for(int i=n-1; i>=0; i--){
            res  = (res + nums[i] *1L* prefix[i+1])%mod;
        }

        return (int)res;
    }
}