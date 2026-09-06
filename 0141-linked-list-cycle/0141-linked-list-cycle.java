/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Initialize two pointers at the head
        ListNode slow = head;
        ListNode fast = head;

        // Traverse while fast pointer can move ahead
        while (fast != null && fast.next != null) {
            // Slow moves one step
            slow = slow.next;

            // Fast moves two steps
            fast = fast.next.next;

            // If both pointers meet, cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches the end, no cycle exists
        return false;
    }
}
