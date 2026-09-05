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
    public ListNode reverseList(ListNode head) {
        // Previous node starts as null
        ListNode prev = null;
        
        // Current node starts from head
        ListNode curr = head;
        
        // Traverse the entire list
        while (curr != null) {
            // Store the next node before breaking the link
            ListNode nextNode = curr.next;
            
            // Reverse the current node's pointer
            curr.next = prev;
            
            // Move prev one step ahead
            prev = curr;
            
            // Move curr one step ahead
            curr = nextNode;
        }
        
        // prev will be the new head of reversed list
        return prev;
    }
}
