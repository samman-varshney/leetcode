package Dynamic_Programming;

import java.util.*;

public class leetcode_2035 {
    HashSet<Integer> set;

    public void helper(int[] nums, int idx, int n, int sum) {
        if (n == 0) {
            set.add(sum);
            return;
        }
        if (nums.length * 2 == idx)
            return;

        // take the element
        helper(nums, idx + 1, n - 1, sum + nums[idx]);

        // do not take the element
        helper(nums, idx, n, sum);

    }

    public int minimumDifference(int[] nums) {
        set = new HashSet<>();
        int n = nums.length/2; 
        helper(nums, 0, n, 0);
        int sum =0 ;
        for(int x: nums){
            sum += x;
        }
        int res = Integer.MAX_VALUE;
        for(int val: set){
            res = Math.min(res, Math.abs(val - sum));
        }   
        return res;
    }
}
