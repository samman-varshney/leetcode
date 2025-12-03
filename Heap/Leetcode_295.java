package Heap;
import java.util.*;

public class Leetcode_295 {
    
}
// TreeSet<Integer> set3 = new TreeSet<>((a, b) -> {
//     if (a % 2 == 0 && b % 2 != 0) return -1;
//     if (a % 2 != 0 && b % 2 == 0) return 1;
//     return a - b;
// });
class Solution {
    TreeSet<Integer> leftHalf;
    TreeSet<Integer> rightHalf;

    public void insert(int index){
        if(leftHalf.isEmpty() || index < leftHalf.last()){
            leftHalf.add(index);
        }else{
            rightHalf.add(index);
        }

        if(leftHalf.size() - rightHalf.size() > 1){
            rightHalf.add(leftHalf.pollLast());
        }else if(rightHalf.size() > leftHalf.size()){
            leftHalf.add(rightHalf.pollLast());
        }
    }

    public double medium(){
        if(leftHalf.size() == rightHalf.size())
            return (leftHalf.last()+rightHalf.last())/2.0;
        return leftHalf.last();
    }

    public void delete(int index){
        if(leftHalf.contains(index)){
            leftHalf.remove(index);
        }else{
            rightHalf.remove(index);
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        leftHalf = new TreeSet<>((a, b)->(nums[a]-nums[b]));
        rightHalf = new TreeSet<>((a, b)->(nums[b]-nums[a]));

        int n = nums.length;
        double[] res = new double[n-k+1];

        int j=0, l=0;
        for(int i=0; i<n; i++){
            if((i-j+1) >= k){
                delete(j);
                j++;
            }
            insert(i);
            if(i>=k-1)res[l++] = medium();
        }   
        return res;
    }
}