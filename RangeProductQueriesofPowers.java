import java.util.*;
class Solution1 {
    static final int MOD = 1000000007;

    // Fast exponentiation for modular power
    private long modPow(long base, long exp, long mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    // Modular inverse using Fermat's Little Theorem (mod must be prime)
    private long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }

    public int[] productQueries(int n, int[][] queries) {
        // Step 1: Decompose n into powers of 2
        int pow = 30;
        ArrayList<Integer> power = new ArrayList<>();
        while (pow >= 0) {
            int num = 1 << pow;
            if (num <= n) {
                power.add(num);
                n -= num;
            }
            pow--;
        }
        // Reverse to make it ascending
        Collections.reverse(power);

        // Step 2: Build prefix product array
        long[] prefix = new long[power.size() + 1];
        prefix[0] = 1;
        for (int i = 0; i < power.size(); i++) {
            prefix[i + 1] = (prefix[i] * power.get(i)) % MOD;
        }

        // Step 3: Answer queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            // range product = prefix[r+1] / prefix[l]  (mod MOD)
            long numerator = prefix[r + 1];
            long denominator = prefix[l];

            long result = (numerator * modInverse(denominator, MOD)) % MOD;
            ans[i] = (int) result;
        }

        return ans;
    }
}
public class RangeProductQueriesofPowers {
    public static void main(String[] args) {
        int n = 15;
        int[][]  queries = {{0,1},{2,2},{0,3}};
        Solution1 s =new Solution1();
        System.out.println(Arrays.toString(s.productQueries(n, queries)));
    }
}
