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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(1, head);
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        while(curr != null && curr.next != null) {
            ListNode next = curr.next;
            
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            
            prev = curr;
            curr = prev.next;
        }
        
        return dummy.next;
    }
}