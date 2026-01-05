class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int minMag = Integer.MAX_VALUE;
        int countOfNegative = 0;
        long sum = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sum += Math.abs(matrix[i][j]);
                minMag = Math.min(Math.abs(matrix[i][j]), minMag);
                if(matrix[i][j] < 0){
                    countOfNegative++;
                }
            }
        }
   
        return sum - (countOfNegative%2==1?2*minMag:0);
    }
}