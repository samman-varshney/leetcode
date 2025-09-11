
import java.util.*;

public class Leetcode_894 {
    class Solution {
        HashMap<Integer, List<TreeNode>> map = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int n) {
            if (n % 2 == 0) {
                return new ArrayList<>();
            }
            if (map.containsKey(n)) {
                return map.get(n);
            }
            List<TreeNode> res = new ArrayList<>();
            if (n == 1) {
                res.add(new TreeNode(0));
                return res;
            }

            for (int i = n - 2, j = 1; i >= 1 && j <= n - 2; i -= 2, j += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(j);
                for (TreeNode leftChild : left) {
                    for (TreeNode rightChild : right) {
                        res.add(new TreeNode(0, leftChild, rightChild));
                    }
                }
            }

            map.put(n, res);
            return res;
        }
    }
}