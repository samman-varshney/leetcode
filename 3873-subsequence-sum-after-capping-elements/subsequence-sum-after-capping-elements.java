class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] sum = new int[k+1];
        sum[0] = 1;
        int i = 0, x = 1;
        boolean[] ans = new boolean[n];
        for( ; x<=n; x++){
            while(i<n && nums[i] <= x){
                int[] temp = new int[k+1];
                for(int j=0; j<=k; j++){  
                    if(sum[j] == 1){
                        temp[j] = 1;
                        if(nums[i] + j <= k)
                            temp[nums[i]+j]=1;
                    }
                }
                sum = temp;
                i++;
            }
            if(sum[k] == 1){
                ans[x-1] = true;
                break;
            }

            for(int j=0; j<=k; j++){
                if(sum[j]==1 && (k-j)%x==0 && (k-j)/x <= n-i){
                    ans[x-1] = true;
                    break;
                }
            }
        }

        for(; x<=n; x++){
            ans[x-1] = true;
        }
        return ans;
    }
}