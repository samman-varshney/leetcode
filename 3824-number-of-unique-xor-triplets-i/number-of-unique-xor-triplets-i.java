class Solution {
    public int log2(int n) {
        return  (int)(Math.log(n) / Math.log(2));
    }
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n <= 2)return n;

        return (int)Math.pow(2, log2(n)+1);
    }
}