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
    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode node = head;
        while(node != null){
            st.add(node);
            node = node.next;
        }

        int carry = 0;
        while(!st.isEmpty()){
            node = st.pop();
            int temp = (node.val*2 + carry);
            node.val = temp%10;
            carry = temp/10;
        }
        if(carry != 0){
            node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        return head;
    }
}
