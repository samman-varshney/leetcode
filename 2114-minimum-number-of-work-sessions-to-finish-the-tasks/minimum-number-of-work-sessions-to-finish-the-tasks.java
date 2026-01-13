class Solution {
    int[] tasks;
    int session;
    int[][] dp;
    int n, required;
    public int helper(int mask, int time){
        if(mask == required){
            return 0;
        }
        if(dp[mask][time] != -1){
            return dp[mask][time]; 
        }
        int min = n;
        for(int i =0; i<n; i++){
            if(((mask>>i)&1) == 0){
                int res;
                if(time - tasks[i] >= 0){
                    res = helper(mask|(1<<i), time - tasks[i]);
                }else{
                    res = helper(mask|(1<<i), session - tasks[i])+1;
                }
                min = Math.min(res, min);
            }
        }
        return dp[mask][time] = min;
    }
    public int minSessions(int[] tasks, int sessionTime) {
        this.n = tasks.length;
        this.tasks = tasks;
        this.session = sessionTime;
        this.required = (1<<n)-1;
        this.dp = new int[required+1][sessionTime+1];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        return helper(0, sessionTime)+1;
    }
}