class Solution {
    public int specialTriplets(int[] nums) {

        int n = nums.length, mod = (int)1e9+7;
        TreeSet<int[]> set = new TreeSet<>((a, b)->(a[0]-b[0]));
        long[] left = new long[n];
        long[] right = new long[n];

        for(int i=0; i<n; i++){
            int[] candidate = set.ceiling(new int[]{nums[i]*2, 0});
            if(candidate!=null && candidate[0] == nums[i]*2){
                left[i] = candidate[1];
            }

            candidate = set.ceiling(new int[]{nums[i], 0});
            if(candidate!=null && candidate[0] == nums[i]){
                candidate[1]++;
            }else{
                set.add(new int[]{nums[i], 1});
            }
        }

        set.clear();

        for(int i=n-1; i>=0; i--){
            int[] candidate = set.ceiling(new int[]{nums[i]*2, 0});
            if(candidate!=null && candidate[0] == nums[i]*2){
                right[i] = candidate[1];
            }

            candidate = set.ceiling(new int[]{nums[i], 0});
            if(candidate!=null && candidate[0] == nums[i]){
                candidate[1]++;
            }else{
                set.add(new int[]{nums[i], 1});
            }
        }
        long res = 0;
        for(int i=0; i<n; i++){
            res = (res+ left[i]*right[i])%mod;
        }
        return (int)res;
    }
}