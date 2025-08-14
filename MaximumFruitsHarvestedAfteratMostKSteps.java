class MySolution_1 {
    public int findUpperBound(int[][] fruits, int val){
        int n = fruits.length;
        int start = 0, end = n-1;
        while(start <= end){
            int mid = (end-start)/2 + start;
            if(fruits[mid][0] >= val){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    public int findLowerBound(int[][] fruits, int val){
        int n = fruits.length;
        int start = 0, end = n-1;
        while(start <= end){
            int mid = (end-start)/2 + start;
            if(fruits[mid][0] <= val){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return end;
    }
    public boolean possible(int[] left, int[] right, int k, int init){
        return Math.min(init - left[0], right[0] - init) + right[0] - left[0] <= k;
    }

    public int maxTotalFruits(int[][] fruits, int init, int k) {
        int leftExtreme = Math.max(fruits[0][0], init - k);
        int rightExtreme = Math.min(fruits[fruits. length-1][0], init+k);
        
        int leftEnd = findLowerBound(fruits, init);
        int leftStart = findUpperBound(fruits, leftExtreme);

        int rightStart = findUpperBound(fruits, init);
        int rightEnd = findLowerBound(fruits, rightExtreme);
        if(leftEnd == rightStart)rightStart++;
        int[][] left = new int[leftEnd < leftStart ? 0:(leftEnd - leftStart + 1)][2];
        int[][] right = new int[rightEnd < rightStart ?  0 : (rightEnd - rightStart + 1)][2];

        int prev = 0;
        for(int i = leftEnd; i>=leftStart; i--){
            left[leftEnd - i][0] = fruits[i][0];
            left[leftEnd - i][1] = fruits[i][1] + prev;
            prev = left[leftEnd - i][1];
        }
        prev = 0;
        for(int i=rightStart; i<=rightEnd; i++){
            right[i-rightStart][0] = fruits[i][0];
            right[i-rightStart][1] = fruits[i][1] + prev;
            prev = right[i-rightStart][1];
        }
        
        int res = left.length == 0?0:left[left.length-1][1];
        
        for(int i=0; i<right.length; i++){
            int start = 0, end = left.length-1;
            while(start <= end){
                int mid = start + (end-start)/2;
                if(possible(left[mid], right[i], k, init)){
                    res = Math.max(right[i][1] + left[mid][1], res);
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
                
            }
            res = Math.max(right[i][1], res);
        }
        return res;
    }
}
public class MaximumFruitsHarvestedAfteratMostKSteps
{
	public static void main(String[] args) {
		MySolution_1 s = new MySolution_1();
		int[][] fruits = {{200000,10000}};
        int init = 0;
        int k = 200000;
        System.out.println(s.maxTotalFruits(fruits, init, k));
	}
}