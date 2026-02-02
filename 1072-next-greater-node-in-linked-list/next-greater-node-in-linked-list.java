/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> st1 = new Stack<>();
        ListNode node = head;
        while(node != null){
            st1.push(node.val);
            node = node.next;
        }
        int n = st1.size();
        int[] res = new int[n];
        Stack<Integer> st2 = new Stack<>();
        for(int i=n-1; i>=0; i--){
            int num = st1.pop();
            while(!st2.isEmpty() && st2.peek() <= num)st2.pop();
            if(st2.isEmpty()){
                res[i] = 0;
            }else{
                res[i] = st2.peek();
            }
            st2.push(num);
        }
        return res;
    }
}