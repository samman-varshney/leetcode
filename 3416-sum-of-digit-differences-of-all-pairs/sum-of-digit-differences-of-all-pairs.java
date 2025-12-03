class Solution {
    public long sumDigitDifferences(int[] nums) {
        int m = (nums[0]+"").length();
        int n = nums.length;
        long dist = 0;
        for(int i=0; i<m; i++){
            int[] freq = new int[10];
            for(int j=0; j<n; j++){
                int rem = nums[j]%10;
                freq[rem]++;
                nums[j] /= 10;
            }
            
            for(int j=0; j<10; j++){
                for(int k=j+1; k<10; k++){
                    dist += freq[j]*1L*freq[k];
                }
            }
        }
        return dist;
    }
}