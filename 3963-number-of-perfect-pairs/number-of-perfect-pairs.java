class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        int[] absolute = new int[n];
        for(int i=0; i<n; i++){
            absolute[i] = nums[i]<0?-nums[i]:nums[i];
        }

        Arrays.sort(absolute);
        long res = 0;
        int j = n-1;
        for(int i=n-1; i>0; i--){
            while(j>=0 && absolute[i] - absolute[j] <= absolute[j]){
                j--;
            }
            res += i - j - 1;
        }
        return res;
    }
}