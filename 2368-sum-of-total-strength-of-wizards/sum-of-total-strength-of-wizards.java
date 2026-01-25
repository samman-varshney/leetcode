class Solution {
    public int totalStrength(int[] nums) {
        int mod = (int)1e9+7;
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = 0;
            }else{
                left[i] = st.peek()+1;
            }
            st.push(i);
        }

        st.clear();
        int[] right = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] > nums[i])
                st.pop();
            if(st.isEmpty()){
                right[i] = n-1;
            }else{
                right[i] = st.peek()-1;
            }
            st.push(i);
        }

        long[] prefix = new long[n+1];
        for(int i=1; i<=n; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        long[] prefixSum = new long[n+1];
        for(int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1] + prefix[i];       
        }

        long[] suffix = new long[n+1];
        for(int i=n-1; i>=0; i--){
            suffix[i] = suffix[i+1] + nums[i];
        }

        long[] suffixSum = new long[n+1];
        for(int i=n-1; i>=0; i--){
            suffixSum[i] = suffixSum[i+1] + suffix[i];
        }

        long res = 0;
        for(int i=0; i<n; i++){
            int r = right[i];
            int l = left[i];

            long rightSum = (prefixSum[r+1] - prefixSum[i] + mod) % mod;
rightSum = (rightSum - (prefix[i] * (r - i + 1) % mod) + mod) % mod;
            long leftSum = ((suffixSum[l] - suffixSum[i] + mod)%mod - suffix[i]*(i - l) + mod)%mod;

            long rcnt = r - i + 1;
            long lcnt = i - l + 1;

           res = (res + (((lcnt * rightSum + rcnt * leftSum) % mod) * nums[i]) % mod) % mod;
        
        }
        
        return (int)res;
    }
}