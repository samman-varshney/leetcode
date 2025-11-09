class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int part1 = 1, part2 = 0;
        int prev = nums[0];
        int res = 1;
        for(int i=1; i<n; i++){
            if(nums[i] >= prev){
                if(part2!=0){
                    part2++;
                }else{
                    part1++;
                }
                prev = nums[i];
            }else if(part2==0){
                part2++;
            }else{
                res = Math.max(res, part1+part2);
                part1 = part2;
                part2 = 0;
                i--;
                prev = nums[i];
            }
        }
        res = Math.max(part1+part2, res);
        part1 = 1; part2 = 0;
        prev = nums[n-1];

        for(int i=n-2; i>=0; i--){
            if(nums[i] <= prev){
                if(part2!=0){
                    part2++;
                }else{
                    part1++;
                }
                prev = nums[i];
            }else if(part2==0){
                part2++;
            }else{
                res = Math.max(res, part1+part2);
                part1 = part2;
                part2 = 0;
                i++;
                prev = nums[i];
            }
        }
        res = Math.max(part1+part2, res);
        return res;
    }
}