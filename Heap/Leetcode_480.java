package Heap;
import java.util.*;
public class Leetcode_480 {
    
}

class Solution {
    TreeSet<Integer> leftHalf;  // smaller half
    TreeSet<Integer> rightHalf; // larger half
    int[] nums;

    public double[] medianSlidingWindow(int[] nums, int k) {
        this.nums = nums;

        // leftHalf: max of smaller half at last
        leftHalf = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b));

        // rightHalf: min of larger half at last
        rightHalf = new TreeSet<>((a, b) -> nums[a] != nums[b] ? Integer.compare(nums[b], nums[a]) : Integer.compare(a, b));

        int n = nums.length;
        double[] res = new double[n - k + 1];

        for (int i = 0, j = 0, l = 0; i < n; i++) {
            insert(i);

            if (i - j + 1 > k) {
                delete(j);
                j++;
            }

            if (i >= k - 1) {
                res[l++] = median();
            }
        }

        return res;
    }

    private void insert(int index) {
        if (leftHalf.isEmpty() || nums[index] <= nums[leftHalf.last()]) {
            leftHalf.add(index);
        } else {
            rightHalf.add(index);
        }

        // balance sizes
        if (leftHalf.size() > rightHalf.size() + 1) {
            rightHalf.add(leftHalf.pollLast());
        } else if (rightHalf.size() > leftHalf.size()) {
            leftHalf.add(rightHalf.pollLast());
        }
    }

    private void delete(int index) {
        if (!leftHalf.remove(index)) {
            rightHalf.remove(index);
        }

        // balance sizes
        if (leftHalf.size() > rightHalf.size() + 1) {
            rightHalf.add(leftHalf.pollLast());
        } else if (rightHalf.size() > leftHalf.size()) {
            leftHalf.add(rightHalf.pollLast());
        }
    }

    private double median() {
        if (leftHalf.size() == rightHalf.size()) {
            return ((double) nums[leftHalf.last()] + nums[rightHalf.last()]) / 2.0;
        }
        return nums[leftHalf.last()];
    }
}
