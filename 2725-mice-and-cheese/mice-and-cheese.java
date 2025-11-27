class Solution {
    public int miceAndCheese(int[] r1, int[] r2, int k) {
        int n = r1.length;
        int[][] nums = new int[n][2];
        for(int i=0; i<n; i++){
            nums[i][0] = r1[i];
            nums[i][1] = r2[i];
        }

        Arrays.sort(nums, (a, b)->{
            int d1 = Math.abs(a[1]-a[0]), d2 = Math.abs(b[1]-b[0]);
            // if(d1 != d2){
                return d1 - d2;
            // }else{
            //     return Math.max(a[0], a[1]) - Math.max(b[0], b[1]);
            // }
        });

        
        int sum = 0;
        int equals = 0;
        for(int i=n-1; i>=0; i--){
            if( i>= k){
                if(nums[i][0] > nums[i][1] && k > 0){
                    k--;
                    sum += nums[i][0];
                }else{
                    sum += nums[i][1];
                }
            }else{
                sum += nums[i][0];
            }
        }
        return sum;
    }
}