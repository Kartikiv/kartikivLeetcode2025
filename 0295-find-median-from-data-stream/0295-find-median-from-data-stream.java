class MedianFinder {
    Queue<Integer> lo; // max-heap, left half (smaller numbers)
    Queue<Integer> hi; // min-heap, right half (larger numbers)

    public MedianFinder() {
        lo = new PriorityQueue<>(Comparator.reverseOrder());
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll());             // push largest of left → right

        if (hi.size() > lo.size() + 1) {  // hi has at most 1 extra
            lo.add(hi.poll());
        }
    }

    public double findMedian() {
        if (hi.size() > lo.size()) return hi.peek(); // odd: hi has the middle
        return (hi.peek() + lo.peek()) / 2.0;        // even: average the two middles
    }
}