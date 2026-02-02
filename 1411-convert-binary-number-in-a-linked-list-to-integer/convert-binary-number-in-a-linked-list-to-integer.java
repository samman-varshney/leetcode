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
    public int getDecimalValue(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode node = head;
        while(node != null){
            st.push(node.val);
            node = node.next;
        }

        int res = 0;
        int n = st.size();
        for(int i=0; i<n; i++){
            int bit = st.pop();
            if(bit == 1){
                res |= 1<<i;
            }
        }
        return res;
    }
}