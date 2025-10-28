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
    public ListNode reverseKGroup(ListNode head, int k) {
        if ( head == null ) return null;
        ListNode node = head;  
        int count = 0;
        while(node!=null && count < k){
            count++;
            node = node.next;

        }
        if(count == k){
           ListNode prev = null;
           ListNode curr = head;
           ListNode next = null;
           for (int i =0; i < k;  i++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
           } 

        head.next = reverseKGroup(node, k) ;


        return prev; }
        
    
    
        
   return head; }
}