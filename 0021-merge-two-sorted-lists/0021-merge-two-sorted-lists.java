import java.util.Comparator;
import java.util.PriorityQueue;

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
        if(list1 == null && list2 == null) return null;
        if(list1 == null ) return list2;
        if(list2 == null) return list1;
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        pq.add(list1);
        pq.add(list2);
        while(!pq.isEmpty()){
            ListNode l1 = pq.poll();
            ans.next = new ListNode(l1.val);
            ans = ans.next;
            if(l1.next != null)  pq.add(l1.next);

        }

        return dummy.next;
    }
}