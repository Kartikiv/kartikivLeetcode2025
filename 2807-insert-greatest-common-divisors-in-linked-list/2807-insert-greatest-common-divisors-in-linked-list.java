



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
/**
 * The Solution class provides a method to insert nodes containing the greatest common divisor (GCD)
 * between every pair of adjacent nodes in a singly linked list.
 *
 * Methods:
 * - insertGreatestCommonDivisors(ListNode head): Traverses the linked list and inserts a new node
 *   between each pair of adjacent nodes. The new node contains the GCD of the values of the two nodes.
 *   Time Complexity: O(n * log(min(a, b))) where n is the number of nodes and log(min(a, b)) is the
 *   time complexity of the GCD calculation.
 *   Space Complexity: O(1) excluding the space for new nodes created.
 *   
 * - gcd(int a, int b): Computes the greatest common divisor of two integers using the Euclidean algorithm.
 *   Time Complexity: O(log(min(a, b)))
 *   Space Complexity: O(log(min(a, b))) due to recursive call stack.
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
