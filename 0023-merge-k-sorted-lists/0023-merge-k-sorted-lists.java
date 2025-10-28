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
 // Brute Force
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        else{
            ListNode[] list = new ListNode[(lists.length + 1)/2]; 
            int j = 0 ;
            for (int i = 0 ; i < lists.length - 1; i = i + 2){
                ListNode merge = mergeTwo(lists[i], lists[i + 1]);
                list[j++] = merge;

            }
            if(lists.length != 1 && lists.length % 2 != 0){
                list[j] = lists[lists.length - 1];
            }
           return mergeKLists(list);
           }
        
            }

    public ListNode mergeTwo(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                dummy = dummy.next;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                dummy = dummy.next;
                list2 = list2.next;
            }
        }
        if(list1 != null){
            dummy.next = list1;
        }else{
            dummy.next = list2;
        }
    return head.next;
    }
}