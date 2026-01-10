class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0; i<n; i++){
            if(rains[i] == 0){
                set.add(i);
            }else{
                int lastOccur = map.getOrDefault(rains[i], -1);
                map.put(rains[i], i);
                if(lastOccur != -1){
                    Integer noRain = set.ceiling(lastOccur);
                    if(noRain == null){
                        return new int[]{};
                    }
                    set.remove(noRain);
                    ans[noRain] = rains[i];
                }
            }
        }
        for(int day: set){
            ans[day] = 1;
        }
        return ans;
    }
}