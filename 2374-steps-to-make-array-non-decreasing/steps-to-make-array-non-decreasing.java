class Pair{
    int steps, curr;
    public Pair(int steps, int curr){
        this.steps = steps;
        this.curr = curr;
    }
}
class Solution {
    int n;
    int[] nums;
    public Pair helper(int prev, int curr){
        int steps = 0;
        int i = curr;
        while(i<n){
            if(nums[i] >= nums[prev]){
                return new Pair(steps, i);
            }
            steps++;
            if(i+1 < n && nums[i+1] < nums[i]){
                Pair p = helper(i, i+1);
                steps = Math.max(p.steps, steps);
                i = p.curr;
            }else{
                i+=1;
            }
        }
        return new Pair(steps, n);
    }
    public int totalSteps(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        int steps = 0;
        int i = 1;
        while(i<n){
            if(nums[i] < nums[i-1]){
                Pair p = helper(i-1, i);
                steps = Math.max(p.steps, steps);
                i = p.curr;
            }else{
                i+=1;
            }
        }
        return steps;
    }
}