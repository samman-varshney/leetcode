import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_1305 {
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        pushLeft(root1, s1);
        pushLeft(root2, s2);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            Stack<TreeNode> stack;
            if (s1.isEmpty()) stack = s2;
            else if (s2.isEmpty()) stack = s1;
            else stack = (s1.peek().val < s2.peek().val) ? s1 : s2;

            TreeNode node = stack.pop();
            res.add(node.val);
            pushLeft(node.right, stack);
        }
        return res;
    }

    private void pushLeft(TreeNode node, Stack<TreeNode> stack) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
    public static void main(String[] args) {
        System.out.println("hello");
    }

}
