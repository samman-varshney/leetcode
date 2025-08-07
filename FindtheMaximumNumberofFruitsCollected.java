import java.util.*;
class NewSolution {
    HashMap<String, Integer> map;
    int n;
    int[][] c1 = {{1, -1}, {1, 0}, {1, 1}};
    int[][] c2 = {{0, -1}, {1, -1}, {1, 0}};
    int[][] c3 = {{-1, 0}, {0, 1}, {1, 1}};

    int solve(int[][] fruits, int i1, int j1, int i2, int j2, int i3, int j3){

        int p1 = fruits[i1][j1], p2 = fruits[i2][j2], p3 = fruits[i3][j3];

        int sum = 0;
        sum += fruits[i1][j1];
        fruits[i1][j1] = 0;
        sum += fruits[i2][j2];
        fruits[i2][j2] = 0;
        sum += fruits[i3][j3];
        fruits[i3][j3] = 0;

        fruits[i1][j1] = p1;
        fruits[i2][j2] = p2;
        fruits[i3][j3] = p3;

        return sum;
    }

    public int helper(int[][] fruits, int i1, int j1, int i2, int j2, int i3, int j3){
        if(i1 == n-1 && i2 == n-1 && i3 == n-1 && j1 == n-1 && j2 == n-1 && j3 == n-1){
            return fruits[n-1][n-1];
        }
       
        String key = (n*i1 +j1) + ","+ (n*i2 + j2) +","+(n*i3+j3);
        if(map.containsKey(key)){
            return map.get(key);
        }

        int[][] d1 = (i1 == n-1 && j1 == n-1 )?new int[][]{{0, 0}}: c1;
        int[][] d2 = (i2 == n-1 && j2 == n-1 )?new int[][]{{0, 0}}: c2;
        int[][] d3 = (i3 == n-1 && j3 == n-1 )?new int[][]{{0, 0}}: c3;

        int max = 0;
        for(int[] x: d1){
            for(int[] y: d2){
                for(int[] z: d3){
                    max = Math.max(max, helper(fruits, i1+x[0], j1+x[1], i2+y[0], j2+y[1], i3+z[0], j3+z[1]));
                }
            }
        }
        int currentSum = solve(fruits, i1, j1, i2, j2, i3, j3);
        map.put(key, max+currentSum);
        return max+currentSum;
    }

    public int maxCollectedFruits(int[][] fruits) {
        map = new HashMap<>();
        n = fruits.length;
        int res = helper(fruits, 0, 0, 0, n-1, n-1, 0);
        return res;
    }
}

public class FindtheMaximumNumberofFruitsCollected {
    public static void main(String[] args) {
        int[][]  fruits = {{1,2,3,4},{5,6,8,7},{9,10,11,12},{13,14,15,16}};
        NewSolution s = new NewSolution();
        System.out.println(s.maxCollectedFruits(fruits));

    }
}
