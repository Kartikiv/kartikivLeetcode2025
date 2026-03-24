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
    public ListNode rotateRight(ListNode head, int k) {
        // normalize k
        if(head == null) return null;
        int size = 1;
        ListNode tail = head;
        while(tail.next != null){ 
            size++; 
            tail = tail.next;
        }
        k = k % size;
        tail.next = head;
        int breakPoint = size - k;
        while (breakPoint > 0) {
            tail = tail.next;
            breakPoint--;
        }
        ListNode ans = tail.next; 
        tail.next = null;
    return ans; 
    }
}