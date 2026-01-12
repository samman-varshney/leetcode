class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i+=2){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int freq1 = 0;
        int freq2 = 0;
        int element1 = -1, element2 = -1;
        for(int element: map.keySet()){
            if(map.get(element) > freq1){
                freq2 = freq1;
                freq1 = map.get(element);
                element2 = element1;
                element1 = element;
            }else if(freq2 < map.get(element)){
                freq2 = map.get(element);
                element2 = element;
            }
        }
       
        map.clear();
        for(int i=1; i<n; i+=2){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int freq3 = 0, freq4 = 0;
        int element3 = -1, element4 = -1;
        for(int element: map.keySet()){
            if(map.get(element) > freq3){
                freq4 = freq3;
                freq3 = map.get(element);
                element4 = element3;
                element3 = element;
            }else if(freq4 < map.get(element)){
                freq4 = map.get(element);
                element4 = element;
            }
        }
        System.out.println("element1 "+element1+" freq1 "+freq1+"\nelement2 "+element2+" freq2 "+freq2+"\nelement3 "+element3+" freq3 "+freq3+"\nelement4 "+element4+" freq4 "+freq4);
        if(element1 != element3){
            return n - freq1 - freq3;
        }else{
            int res1 = n - freq1 -freq4;
            int res2 = n - freq3 - freq2;
            return Math.min(res1, res2);
        }
    }
}