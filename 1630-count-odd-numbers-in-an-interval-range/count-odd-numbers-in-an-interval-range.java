class Solution {
    public int countOdds(int low, int high) {
        return (high-low+1)/2 + (((high-low+1)&1) == 1?low&1:0);
    }
}