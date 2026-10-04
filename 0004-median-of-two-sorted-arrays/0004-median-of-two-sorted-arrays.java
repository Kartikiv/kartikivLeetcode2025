class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // One basic way is maintaing a min heap
        // and a maxheap
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b) -> b - a);
        int i = 0;
        int j = 0;
        double median = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length)
                minQueue.add(nums1[i]);
                i++;
            if (j < nums2.length)
                minQueue.add(nums2[j]);
                j++;

            while (minQueue.size() > maxQueue.size()) {
                int node = minQueue.poll();
                maxQueue.add(node);
            }
        }
        if(minQueue.size() == maxQueue.size()){ 
            double a = (double)minQueue.peek();
            double b = (double)maxQueue.peek();
            return (a + b) / 2;
        }else{ 
            return (double) maxQueue.peek();
        }
    }
}