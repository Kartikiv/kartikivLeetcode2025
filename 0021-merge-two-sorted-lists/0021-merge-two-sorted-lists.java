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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while(list1 != null && list2 != null){
           ListNode newNode = null;
           int nodeVal = 0;
           if (list1.val > list2.val) {
            newNode = new ListNode(list2.val);
            list2 = list2.next;
            } 
            else {
            newNode = new ListNode(list1.val);    
            list1 = list1.next;
            }
           node.next = newNode;
           node = node.next;
        }
        if (list1 != null){
            node.next = list1;
        }else{
            node.next = list2;
        }
    return dummy.next;}
}