class Solution {
    
    static int MAX=1_000_000;
    
    static int MOD=1_000_000_007;
    public int divisibleGame(int[] nums) {
       
       
          HashSet<Integer>set=new HashSet<>();
      
        int p=0;
        for(int i=0;i<nums.length;i++){
            p+=nums[i];
        }
        if(p==nums.length){
            return 1000000005;
        }
        for(int a:nums){
            int x=a;
      
      for (int d = 2; d * d <= x; d++) {
    if (x % d == 0) {
        set.add(d);
        set.add(x / d);
    }
}
if(x>1)
set.add(x);
        }
        int max_differ=Integer.MIN_VALUE;
        int k=1;
          for(int b:set){
            int sum=Integer.MIN_VALUE;
            int diff=Integer.MIN_VALUE;
            for(int j=0;j<nums.length;j++){
                 int val=nums[j]%b==0?nums[j]:-nums[j];
                     if (sum == Integer.MIN_VALUE)
                     sum = val;
                     else 
                      sum = Math.max(val, sum + val); 
                      diff = Math.max(diff, sum);
            }
          
            if(max_differ<diff||(max_differ==diff&&b<k)){
                max_differ=diff;
                k=b;
            }
            
          
        }
        // long ans=(1L*max_differ*k)%MOD;
        // return(int) ans;
        long ans = (1L * max_differ * k) % MOD;
           if(ans < 0)
           ans += MOD;
           return (int)ans;

    }
   
    }