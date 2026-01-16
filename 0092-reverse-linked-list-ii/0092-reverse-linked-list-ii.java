class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 1) Walk `prev` to node before `left`
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 2) Reverse sublist of length (right-left+1)
        ListNode curr = prev.next;      // first node in sublist
        ListNode subPrev = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = subPrev;
            subPrev = curr;
            curr = next;
        }

        // 3) Stitch back
        // prev.next is old start of sublist, now becomes tail
        ListNode subTail = prev.next;
        prev.next = subPrev;
        subTail.next = curr;

        return dummy.next;
    }
}
