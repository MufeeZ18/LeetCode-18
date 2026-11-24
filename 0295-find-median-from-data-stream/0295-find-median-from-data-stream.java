import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    // Max-heap: exposes the largest number in the lower half.
    private final PriorityQueue<Integer> lower;

    // Min-heap: exposes the smallest number in the upper half.
    private final PriorityQueue<Integer> upper;

    public MedianFinder() {
        lower = new PriorityQueue<>(Collections.reverseOrder());
        upper = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Insert into the lower half first.
        lower.offer(num);

        // Move its largest value up to preserve ordering.
        upper.offer(lower.poll());

        // Keep lower the same size as upper, or one larger.
        if (lower.size() < upper.size()) {
            lower.offer(upper.poll());
        }
    }

    public double findMedian() {
        // An odd total means lower contains the middle value.
        if (lower.size() > upper.size()) {
            return lower.peek();
        }

        // Cast before adding to prevent integer overflow.
        return ((double) lower.peek() + upper.peek()) / 2.0;
    }
}
