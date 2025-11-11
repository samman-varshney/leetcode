class Solution {
    public int maxSum(int[] arr1, int[] arr2) {
        int mod = 1_000_000_007;
        int n1=arr1.length, n2 = arr2.length;
        long sum1 = 0, sum2 = 0;
        long ans = 0;
        int i = 0,j = 0;
        // boolean match = false;
        while(i<n1 && j<n2){
            if(arr1[i] == arr2[j]){
                sum1 += arr1[i];
                sum2 += arr2[j];
                ans += sum1>sum2?sum1:sum2;
                i++;
                j++;
                sum1 = sum2 =0;
            }
            else if(arr1[i] > arr2[j]){
                sum2 += arr2[j];
                j++;
            }
            else{
                sum1 += arr1[i];
                i++;
            }
        }
        while(i<n1){
            sum1 += arr1[i++];
        }
        while(j<n2){
            sum2 += arr2[j++];
        }
        ans+=Math.max(sum1,sum2);
        return (int)(ans%mod);
    }
}
