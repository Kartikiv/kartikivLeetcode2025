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
    public ListNode partition(ListNode head, int x) {
        ListNode dummySmall = new ListNode(-1);
        ListNode smallPart = dummySmall;
        ListNode dummyLarge = new ListNode(-1);
        ListNode largePart = dummyLarge;
        while (head != null) {
            if (head.val < x) {
                smallPart.next = new ListNode(head.val);
                smallPart = smallPart.next;
            } else {
                largePart.next = new ListNode(head.val);
                largePart = largePart.next;
            }
            head = head.next;

        }
        ListNode temp = dummyLarge;
        dummyLarge = dummyLarge.next;
        temp.next = null;
        smallPart.next = dummyLarge;
        return dummySmall.next;
    }
}