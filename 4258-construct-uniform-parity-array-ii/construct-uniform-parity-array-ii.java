class Solution {
    public boolean uniformArray(int[] nums1) {
        int allEven = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums1.length; i++){
            allEven |= (nums1[i]&1);
            min = Math.min(min, nums1[i]);
        }

        return min%2 == 1 || allEven==0;
    }
}