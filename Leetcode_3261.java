import java.util.Arrays;

public class Leetcode_3261 {
    public static void main(String[] args) {
        solution_3261 l = new solution_3261();
        long[] res  = l.countKConstraintSubstrings("010101", 1, new int[][]{{0,5},{1,4},{2,3}});
        System.out.println(Arrays.toString(res));
    }
}
class solution_3261 {
    public int upperBound(int[] arr, int val){
        int n = arr.length;
        int start = 0, end = n-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] >= val){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length();
        int m = queries.length;
        int[] ones = new int[n+1];
        int[] zeros = new int[n+1];

        for(int i=0; i<n; i++){
            ones[i+1] = ones[i] + (s.charAt(i) == '1'? 1: 0);
            zeros[i+1] = zeros[i] + (s.charAt(i) == '0'? 1: 0);
        }

        long[] res = new long[m];
         
        for(int j=0; j<m; j++){

            int l = queries[j][0];
            int r = queries[j][1];
            long count = 0;
            int i=l+1;
            while(i<= r+1){

                int min = Math.min(ones[i]-ones[l], zeros[i]-zeros[l]);
                if(min <= k){
                    count += i-l;
                    i++;
                }else{
                    int ol = upperBound(ones, ones[i]-k);
                    int zl = upperBound(zeros, zeros[i]-k);

                    l = Math.min(ol, zl);
                }
            }
            res[j] = count;
        }
        return res;
    }
}