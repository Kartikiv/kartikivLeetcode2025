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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode sizeNode = head;
        int size = 0;
        while(sizeNode != null){
            size++;
            sizeNode = sizeNode.next;
        }
        k = k % size;
        if(k == 0 ) return head;
        ListNode temp = head;
        ListNode curr = head;
        while (k > 0) {
            temp = temp.next;
            k--;

        }

        while (temp != null && temp.next != null){
            temp = temp.next;
            curr = curr.next;
        }
        temp = curr.next;
        curr.next = null;
        curr = temp;
        while (curr != null && curr.next!= null){
            curr = curr.next;
        }
        curr.next = head;



        return temp;}

    ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return  prev;}
}