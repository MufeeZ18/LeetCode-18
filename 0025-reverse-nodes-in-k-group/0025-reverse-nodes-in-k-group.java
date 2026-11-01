class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // A group of one needs no reversal.
        if (k == 1) return head;

        // Dummy node simplifies replacing the list's head.
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            // Find the last node of a complete group.
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // Leave an incomplete final group unchanged.
            if (kth == null) return dummy.next;

            // Preserve the next group and this group's original head.
            ListNode groupNext = kth.next;
            ListNode groupStart = groupPrev.next;

            // The reversed group's tail must point to groupNext.
            ListNode prev = groupNext;
            ListNode curr = groupStart;

            while (curr != groupNext) {
                ListNode next = curr.next; // Save the original next node.
                curr.next = prev;         // Reverse the current link.
                prev = curr;              // Advance the reversed portion.
                curr = next;              // Process the next original node.
            }

            // Connect the previous group to the new head.
            groupPrev.next = kth;

            // The original head is now the tail.
            groupPrev = groupStart;
        }
    }
}
