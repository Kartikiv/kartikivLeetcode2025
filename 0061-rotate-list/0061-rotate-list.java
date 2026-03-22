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
        if(head == null) return head; 
        // go to the middle node and reverse the linked list 
        // then interweave the two node
        // lets to brute force first
        ListNode sizeNode = head;
        int size = 0 ; 
        while (sizeNode != null) {
            size++;
            sizeNode = sizeNode.next;
        }
        k = k % size;
        if(k == size || k == 0 ) return head;
        
        ListNode firstNode = head; 
        ListNode secondNode = head; 
        while (k > 0) {
            secondNode = secondNode.next;
            k--;
        }
        while(secondNode != null && secondNode.next != null){
            secondNode = secondNode.next; 
            firstNode = firstNode.next;
        }
        ListNode reversedNode = firstNode.next; 
        firstNode.next = null;
        secondNode.next = head;
        return reversedNode;
}
}