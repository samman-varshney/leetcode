class Solution {
    public int countCoveredBuildings(int m, int[][] buildings) {
        int n = buildings.length;
        int[][] nums = new int[n][3];
        for(int i=0; i<n; i++){
            nums[i][0] = buildings[i][0];
            nums[i][1] = buildings[i][1];
        }

        Arrays.sort(nums, (a, b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            return a[1] - b[1];
        });

        for(int i=1; i<n; i++){
            if(nums[i][0] == nums[i-1][0]){
                nums[i][2]++;
            }
        }
        for(int i=n-2; i>=0; i--){
            if(nums[i][0] == nums[i+1][0]){
                nums[i][2]++;
            }
        }

        Arrays.sort(nums, (a, b)->{
            if(a[1]!=b[1])
                return a[1] - b[1];
            return a[0] - b[0];
        });

        for(int i=1; i<n; i++){
            if(nums[i][1] == nums[i-1][1]){
                nums[i][2]++;
            }
        }
        for(int i=n-2; i>=0; i--){
            if(nums[i][1] == nums[i+1][1]){
                nums[i][2]++;
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i][2] == 4){
                count++;
            }
        }
        return count;

    }
}