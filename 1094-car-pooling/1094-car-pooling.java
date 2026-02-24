class StackNode{
    int endTime; 
    int numPassenger;

    public StackNode(int endTime, int numPassenger){
        this.endTime = endTime;
        this.numPassenger = numPassenger;
    }
}
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        int currentCapacity = 0 ;
        PriorityQueue<StackNode> queue = new PriorityQueue<>((a,b) -> a.endTime - b.endTime); 
        for (int [] trip : trips){
            currentCapacity += trip[0];
            while(!queue.isEmpty() && queue.peek().endTime <= trip[1]){
                currentCapacity -= queue.poll().numPassenger;
            }
            queue.add(new StackNode(trip[2], trip[0]));
            if(currentCapacity > capacity) return false;

        }
    return true;
     }
}