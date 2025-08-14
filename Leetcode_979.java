/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
/**
 * Definition for a binary tree node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 import java.util.*;

class Node {
     int val;
     Node left;
     Node right;
     Node() {}
     Node(int val) { this.val = val; }
     Node(int val, Node left, Node right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
class MySolution_979 {
        int moves;
    public int helper(Node root){
        if( root == null )return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        moves += Math.abs(left)+Math.abs(right);
        return root.val + left + right - 1;
    }
    public int distributeCoins(Node root) {
        moves = 0;
        helper(root);
        return moves;
    }
}


public class Leetcode_979 {
    public static void main(String[] args) {
        Integer[] arr = {0,8,0,10,0,null,null,0,0,11,0,0,0,null,0,0,null,null,0,null,0,0,0,0,0,0,0,null,null,10,null,0,0,0,null,0,1,null,null,null,null,0,null,null,null,0,0,0,0,0,0,null,null,null,0,null,null,null,0,null,0,0,null,0,null,null,null,0};
        Node root = buildTree(arr);
        // printTree(root); // Optional - to verify structure
        MySolution_979 s = new MySolution_979();
        System.out.println(s.distributeCoins(root));
    }

    public static Node buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }

    // // Helper to check tree structure
    // public static void printTree(Node root) {
    //     Queue<Node> q = new LinkedList<>();
    //     q.offer(root);
    //     while (!q.isEmpty()) {
    //         Node node = q.poll();
    //         if (node == null) {
    //             System.out.print("null ");
    //             continue;
    //         }
    //         System.out.print(node.val + " ");
    //         q.offer(node.left);
    //         q.offer(node.right);
    //     }
    // }
}
