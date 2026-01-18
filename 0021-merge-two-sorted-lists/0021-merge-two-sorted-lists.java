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
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> Integer.      compare(a.val, b.val));
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        if(list1 == null ) return list2;
        if(list2 == null)  return list1;
        pq.add(list1);
        pq.add(list2);

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;
            if(node.next != null){
                node = node.next;
                pq.add(node);
            }
        }

    return ans.next; 
    }
}