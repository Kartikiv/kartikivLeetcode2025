class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode first = head;
        ListNode second = head;

        while (first != null) {
            while (second != null && second.val == first.val) {
                second = second.next;
            }

            if (first.next == second) {
                prev.next = first;
                prev = first;
            }

            first = second;
        }

        prev.next = null;
        return dummy.next;
    }
}