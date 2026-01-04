class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i=0; i<n; i++){
            int count = 2;
            int sum = nums[i]+1;
            for(int j=2; j*j<=nums[i]; j++){
                if (nums[i] % j == 0) {
                    if (j * j == nums[i]) {
                        count += 1;
                        sum += j;
                    } else {
                        count += 2;
                        sum += j + nums[i] / j;
                    }
                }
            }
            if(count == 4){
                result += sum;
            }
        }
        return result;
    }
}