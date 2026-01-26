class Solution {
    Boolean[] dp;
    
    boolean helper(int tar, int mask) {
        if (tar <= 0) {
            return false; // Previous player already won
        }
        
        if (dp[mask] != null) {
            return dp[mask];
        }
        
        // Try each available number
        for (int i = 1; i <= 20; i++) {
            int bit = 1 << i;
            if ((mask & bit) != 0) { // if number i is available
                // If picking i wins immediately OR puts opponent in losing position
                if (i >= tar || !helper(tar - i, mask ^ bit)) {
                    dp[mask] = true;
                    return true;
                }
            }
        }
        
        dp[mask] = false;
        return false;
    }
    
    public boolean canIWin(int limit, int total) {
        if (total <= 0) return true;
        if ((limit * (limit + 1)) / 2 < total) return false;
        
        dp = new Boolean[(1 << (limit + 1))];
        int initialMask = ((1 << (limit + 1)) - 1) ^ 1; // bits 1 to limit set
        
        return helper(total, initialMask);
    }
}