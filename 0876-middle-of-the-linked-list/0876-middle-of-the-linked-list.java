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
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        size = size /2;
        ListNode ans = head;
        while(size > 0){
            ans = ans.next;
            size--;
        }


    return ans; }
}