class Solution {
    public ListNode oddEvenList(ListNode head) {
        // If list is empty or has only one node, no reordering is needed
        if (head == null || head.next == null) {
            return head;
        }

        // odd points to nodes at odd positions
        ListNode odd = head;

        // even points to nodes at even positions
        ListNode even = head.next;

        // Store the head of even list so we can attach it later
        ListNode evenHead = even;

        // Rearrange links while there are still even pairs available
        while (even != null && even.next != null) {
            // Link current odd node to the next odd node
            odd.next = even.next;
            odd = odd.next;

            // Link current even node to the next even node
            even.next = odd.next;
            even = even.next;
        }

        // Attach even list after the odd list
        odd.next = evenHead;

        // Return the modified list
        return head;
    }
}
