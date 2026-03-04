/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;

        ListNode curr = head;

        ListNode next = head.next;
        while (curr.next != null && next.next != null) {
            dummy.next = next;
            curr.next = next.next;
            next.next = curr;

            ListNode temp = curr;
            curr = next;
            next = temp;

            dummy = dummy.next.next;
            curr = curr.next.next;
            next = next.next.next;
        }
        if(next != null) {
            dummy.next = next;
            curr.next = next.next;
            next.next = curr;
        }

        return ans.next;
    }
}