class KthLargest {

    int[] minHeap;
    int capacity;
    int currSize;

    public KthLargest(int k, int[] nums) {
        capacity = k;
        minHeap = new int[k];
        currSize = 0;

        // Add all elements using add() method to ensure heap size = k
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (currSize < capacity) {
            // Heap not full, insert at end
            minHeap[currSize] = val;
            heapifyUp(currSize);
            currSize++;
        } else if (val > minHeap[0]) {
            // Replace root and heapify down
            minHeap[0] = val;
            heapifyDown(0);
        }
        return minHeap[0];
    }

    void heapifyDown(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < currSize && minHeap[left] < minHeap[smallest])
            smallest = left;
        if (right < currSize && minHeap[right] < minHeap[smallest])
            smallest = right;

        if (smallest != i) {
            int temp = minHeap[i];
            minHeap[i] = minHeap[smallest];
            minHeap[smallest] = temp;
            heapifyDown(smallest);
        }
    }

    void heapifyUp(int i) {
        int parent = (i - 1) / 2;
        while (i > 0 && minHeap[parent] > minHeap[i]) {
            int temp = minHeap[parent];
            minHeap[parent] = minHeap[i];
            minHeap[i] = temp;
            i = parent;
            parent = (i - 1) / 2;
        }
    }
}