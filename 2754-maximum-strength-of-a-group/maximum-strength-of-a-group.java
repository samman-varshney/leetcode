class Solution {
    public long maxStrength(int[] nums) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for(int i:nums){
            if(i<0){
                neg.add(i);
            }
            else if(i>0){
                pos.add(i);
            }
        }
        Arrays.sort(nums);
         neg.sort((a, b) -> Math.abs(a) - Math.abs(b));
        if(neg.size()%2!=0){
            neg.remove(0);
        }
        if(pos.isEmpty() && neg.isEmpty()){
            int m=nums[0];
            for(int x:nums){
                m=Math.max(m,x);
            }
            return m;
        }
        long prod=1;
        for(int x:neg){
            prod*=x;

        }
        for(int x:pos){
            prod*=x;
        }
        return prod;



    }
}