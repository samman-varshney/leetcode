class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();   

        long cnt = 0;
        int j = -1;

        for(int i=0; i<n; i++){
            while(!min.isEmpty() && nums[min.peekLast()] >= nums[i])min.removeLast();
            while(!max.isEmpty() && nums[max.peekLast()] <= nums[i])max.removeLast();

            min.add(i);
            max.add(i);

            if(nums[min.peekFirst()] < minK || nums[max.peekFirst()] > maxK){
                min.clear();
                max.clear();
                j = i;
            }else if(nums[min.peekFirst()] == minK && nums[max.peekFirst()] == maxK){
                cnt += Math.min(min.peekFirst(), max.peekFirst()) - j;
            }
        }

        return cnt;
    }
    
}