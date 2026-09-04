class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i<n; i++){
            while(!dq.isEmpty() && nums[i] > dq.peekLast())
                dq.removeLast();
            
            dq.addLast(nums[i]);
            left[i] = dq.peekFirst();
        }

        dq.clear();

        int[] right = new int[n];

        for(int i = n-1; i>=0; i--){
            while(!dq.isEmpty() && nums[i] < dq.peekLast())
                dq.removeLast();
            
            dq.addLast(nums[i]);
            right[i] = dq.peekFirst();
        }

        for(int i = 0; i<n; i++){
            int score  = left[i] - right[i];
            if(score <= k){
                return i;
            }
        }
        return -1;
    }
}