class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = 0;
            }else{
                left[i] = st.peek()+1;
            }
            st.push(i);
        }

        System.out.println(Arrays.toString(left));
        long res = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            res += 1;
            if(map.containsKey(nums[i])){
                int j = left[i];
                res += helper(map.get(nums[i]), j);
            }
            map.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        }
        return res;
    }

    public long helper(List<Integer> nums, int val){
        int start  = 0, end = nums.size()-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums.get(mid) >= val){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return nums.size() - start;
    }
}