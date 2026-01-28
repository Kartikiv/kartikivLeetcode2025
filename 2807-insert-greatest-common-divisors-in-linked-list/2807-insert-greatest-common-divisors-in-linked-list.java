



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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode current = head;
        ListNode nextNode = null;


        while (current.next != null) {
            nextNode = current.next;
           
            int val1 = current.val;
            int val2 = current.next.val;

            ListNode temp = new ListNode(gcd(val1, val2));

            current.next = temp;
            temp.next = nextNode;

            current = nextNode;


        }
        
        
    return  head;}
    
    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }
}
