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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode p1 = head; 
        ListNode p2 = head; 
        while(p2 != null && n > 0){ 
            p2 = p2.next;
           n--;
        }
        if (p2 == null) {
            return head.next;
        }
        while (p2 != null && p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
            
        }
        p1.next = p1.next.next;
    return head; 
    }
}
