class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        int n = s.length();
        long ones = 0, zeros = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.charAt(i) == '0'){
                    zeros++;
                }else{
                    ones++;
                }
            }
        }
        
        if(flipCost*2 <= swapCost){
            return (ones+zeros)*flipCost;
        }

        long neck = Math.min(ones, zeros);
        long cost = neck*swapCost;

        long remaining = Math.max(ones, zeros)-neck;

        if(flipCost*2 <= swapCost + crossCost){
            return cost + remaining*flipCost;
        }
        
        return cost + remaining/2 * (swapCost + crossCost) + (remaining%2)*flipCost;
    }
}