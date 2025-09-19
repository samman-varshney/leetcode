import java.util.Arrays;

public class MergeSort {
    public static void divide(int start , int end, int[] arr){
        if(end - start  <= 0)return;

        int mid = start + (end - start)/2;
        divide(start, mid, arr);
        divide(mid+1, end, arr);

        merge(start, mid, end, arr);
    }

    public static void merge(int start, int mid, int end, int arr[]){
        int[] sort = new int[end - start + 1];

        int i=start, j=mid+1, k=0;
        while(i<=mid && j<=end){
            if(arr[i] < arr[j]){
                sort[k] = arr[i++];
            }else{
                sort[k] = arr[j++];
            }
            k++;
        }

        while(i<= mid){
            sort[k++] = arr[i++];
        }
        while(j<= end){
            sort[k++] = arr[j++];
        }

        for(k=0; k<sort.length; k++){
            arr[start+k] = sort[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {34, 12, 0, 37, 47, 94};
        divide(0, arr.length-1, arr);
        System.out.println(Arrays.toString(arr));
    }
}
