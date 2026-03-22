class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean allEven = true;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<nums1.length; i++){
            if(nums1[i]%2 == 1)
                allEven = false;
            min = Math.min(min, nums1[i]);
        }

        return min%2 == 1 || allEven;
    }
}