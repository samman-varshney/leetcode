import java.util.Arrays;

public class Leetcode_3261 {
    public static void main(String[] args) {
        solution_3261 l = new solution_3261();
        long[] res  = l.countKConstraintSubstrings("010101", 1, new int[][]{{0,5},{1,4},{2,3}});
        System.out.println(Arrays.toString(res));
    }
}


class solution_3261 {

    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length();
     
        int[] d = new int[n];
        Arrays.fill(d, n);

        long[] pre = new long[n + 1]; 
        int[] cnt = new int[2]; 
         int left = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            cnt[c - '0']++;

    
            while (cnt[0] > k && cnt[1] > k) {
              
                d[left] = right;
                
                cnt[s.charAt(left) - '0']--;
                left++;
            }

            
            pre[right + 1] = pre[right] + (right - left + 1);
        }

        
        int q = queries.length;
        long[] ans = new long[q];
        for (int qi = 0; qi < q; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];

           int pivot = Math.min(r + 1, d[l]);

            long len = (pivot - l);  
            long partA = len * (len + 1) / 2;  
            long partB = pre[r + 1] - pre[pivot];

            ans[qi] = partA + partB;
        }

        return ans;
    }
}

  