
import java.util.Currency;/**
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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null; 
        ListNode curent = head; 
        while (curent != null) {
            next = curent.next; 
            curent.next = prev; 
            prev = curent; 
            curent = next;
        }
    return prev; 
    }
}