package Dynamic_Programming.LIS;
import java.util.*;
//https://www.geeksforgeeks.org/dsa/dynamic-programming-building-bridges/

public class BuildingBridges {
    public static int upperBound(int val, List<Integer> list){
        int n = list.size();
        int start = 0, end = n-1;
        while(start <= end){
            int mid=start + (end-start)/2;
            if(list.get(mid) >= val){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    public static int helper(int[] north, int[] south){
        int n = north.length;
        List<Integer> list = new ArrayList<>();
        int[][] address = new int[n][2];
        for(int i=0; i<n; i++){
            address[i][0] = i;
            address[i][1] = north[i];
        }
        Arrays.sort(address, (a, b)->(a[1]-b[1]));
        for(int i=0; i<n; i++){
            int idx = address[i][0];
            int city = south[idx];
            int pos = upperBound(city, list);
            if(pos == list.size()){
                list.add(city);
            }else{
                list.set(pos, city);
            }
        }

        return list.size();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] north = new int[n];
        for(int i=0; i<n; i++)
            north[i] = sc.nextInt();
        int[] south = new int[n];
        for(int i=0; i<n; i++)
            south[i] = sc.nextInt();
        System.out.println(helper(north, south));
        sc.close();
    }
}
