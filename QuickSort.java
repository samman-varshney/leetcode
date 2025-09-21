import java.util.Arrays;

public class QuickSort {
    public static int partition(int start, int end, int[] arr){
        int i = start-1, j=start;
        int povit = arr[end];
        while(j<=end){
            if(arr[j] <= povit){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            j++;
        }
        return i;
    }

    public static void quick(int start, int end, int[] arr){
        if(start >= end )return;

        int pi = partition(start, end, arr);

        quick(start, pi-1, arr);
        quick(pi+1, end, arr);
    }

    public static void main(String[] args) {
        int[] arr = {23, 1, 67, 9, 20, 203};
        quick(0, arr.length-1, arr);
        System.out.println(Arrays.toString(arr));
    }
}
