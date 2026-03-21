import java.util.*;

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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode listNode : lists) {

            if(listNode != null) pq.add(listNode);
        }
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = node;
            node = node.next; 
            if(node != null) pq.add(node);
            dummy = dummy.next;
        }
    return ans.next; }
}