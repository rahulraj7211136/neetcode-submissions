class MedianFinder {
    PriorityQueue<Integer>minHeap, maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return (double)maxHeap.peek();
        return ((double)maxHeap.peek() + (double)minHeap.peek())/2.0;
    }
}
