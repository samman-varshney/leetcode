class Solution {
    public long countSubarrays(int[] nums, long k) {
        Deque<Integer> min = new ArrayDeque<>();
        Deque<Integer> max = new ArrayDeque<>();

        int j = 0;
        long count = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            //insertion into queues
            while(!min.isEmpty() && nums[min.peekLast()] >= nums[i]){
                min.removeLast();
            }
            min.addLast(i);
        
            while(!max.isEmpty() && nums[max.peekLast()] <= nums[i]){
                max.removeLast();
            }
            max.addLast(i);

            //verify the condition
            while(j<=i && (nums[max.peekFirst()] - nums[min.peekFirst()])*1L*(i - j + 1) > k){
                if(max.peekFirst() <= j)
                    max.removeFirst();
                if(min.peekFirst() <= j)
                    min.removeFirst();
                j++;
            }

            count += i - j + 1;
        }
        return count;
    }
}