package Test;

import java.util.*;
import java.util.function.BiConsumer;

public class q2 {
    // return array of starvation times
    public static int[] findStarvation(int[] priorities) {
        int n = priorities.length;
        // coordinate compress
        int[] vals = Arrays.stream(priorities).distinct().sorted().toArray();
        HashMap<Integer, Integer> comp = new HashMap<>();
        for (int i = 0; i < vals.length; ++i)
            comp.put(vals[i], i + 1);
        int m = vals.length;
        int[] bit = new int[m + 1];

        // fenwick max
        BiConsumer<Integer, Integer> bitUpdate = (i, val) -> {
            while (i <= m) {
                if (bit[i] < val)
                    bit[i] = val;
                i += i & -i;
            }
        };
        java.util.function.IntUnaryOperator bitQuery = (i) -> {
            int res = 0;
            while (i > 0) {
                if (bit[i] > res)
                    res = bit[i];
                i -= i & -i;
            }
            return res;
        };

        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; --i) {
            int idx = comp.get(priorities[i]) - 1; // strictly less
            if (idx >= 1) {
                int j = bitQuery.applyAsInt(idx);
                if (j != 0)
                    ans[i] = j - i;
            }
            bitUpdate.accept(comp.get(priorities[i]), i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findStarvation(new int[]{8, 2, 5, 3})));
    }

}
