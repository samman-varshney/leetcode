import java.util.*;

public class Monubhaiyaandexpression {
    static class Node {
        String val;
        Node left;
        Node right;

        public Node(String val) {
            this.val = val;
        }
    }

    public static void levelOrder(Node root) {

        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();
            if (current != null) {
                System.out.print(current.val);
                queue.add(current.left);

                queue.add(current.right);
            } else {
                System.out.print(-1);
            }
        }
    }

    static void reverse(String[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tcase = sc.nextInt();
        while (tcase-- > 0) {
            String s = sc.next();
            String[] postfix = getPostfix(s);
            reverse(postfix);
            System.out.println(Arrays.toString(postfix));
            idx = 0;
            Node root = buildTree(postfix);

            levelOrder(root);
            System.out.println();
        }
        sc.close();
    }

    static int idx;
    static String[] operator = { "/", "+", "-", "*" };

    public static boolean isOperator(String op) {
        for (String s : operator) {
            if (s.equals(op)) {
                return true;
            }
        }
        return false;
    }

    public static Node buildTree(String[] postfix) {

        Node root = new Node(postfix[idx]);
        idx++;
        if (!isOperator(root.val)) {
            return root;
        }

        Node right = buildTree(postfix);
        Node left = buildTree(postfix);

        root.left = left;
        root.right = right;

        return root;
    }

    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String[] getPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c + ",");
            }

            else if (c == '(') {
                stack.push(c);
            }

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop() + ",");
                }
                stack.pop();
            }

            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop() + ",");
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop() + ",");
        }

        return result.toString().split(",");
    }
}