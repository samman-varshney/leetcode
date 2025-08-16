import java.util.HashMap;

public class Leetcode_437 {
    HashMap<Long, Integer> map;
    public int helper(TreeNode node, long currSum, int targetSum){
        if(node == null) return 0;

        currSum += node.val;

        int count = 0;
        count += map.getOrDefault(currSum - targetSum, 0);

        map.put(currSum, map.getOrDefault(currSum, 0)+1);

        count += helper(node.left, currSum, targetSum);
        count += helper(node.right, currSum, targetSum);

        map.put(currSum, map.get(currSum)-1);
        return count;

    }
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0L, 1);
        return helper(root, 0l, targetSum);
    }
}
