
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
    public void reorderList(ListNode head) {
        ListNode middleNode = middle(head);
        ListNode reverseNode = reverse(middleNode.next);
        middleNode.next = null;
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        while(head != null && reverseNode != null){
            dummy.next = head;
            head = head.next; 
            dummy = dummy.next; 
            dummy.next = reverseNode; 
            reverseNode = reverseNode.next; 
            dummy = dummy.next; 
        }
        dummy.next = head == null ? reverseNode : head;
     head = ans.next; }
    //reverse
    ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
    return slow;
    }
    ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    return prev;
    }

}