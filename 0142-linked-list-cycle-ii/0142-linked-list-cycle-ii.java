/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode rabbit = head;
        ListNode tortoise = head;

        while (rabbit != null && rabbit.next != null) {
            tortoise = tortoise.next;
            rabbit = rabbit.next.next;
            if (rabbit == tortoise) {
                break;
            }

        }

        if (rabbit == null || rabbit.next == null) return null;
        rabbit = head; 
        while (rabbit != tortoise) {
            rabbit = rabbit.next; 
            tortoise = tortoise.next;
        }
         
    return rabbit; }

}