class RecentCounter {
    Deque<Integer> deque;
    public RecentCounter() {
        this.deque = new LinkedList<>();
    }
    
    public int ping(int t) {
        deque.addLast(t);
        while(!deque.isEmpty() && deque.peekFirst() < t - 3000){
            deque.pollFirst();
        }
    return deque.size(); 
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */