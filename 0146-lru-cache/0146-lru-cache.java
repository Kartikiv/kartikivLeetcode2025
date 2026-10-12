
class LRUCache {
    LinkedHashMap<Integer,Integer> store; 
    int capacity;
    public LRUCache(int capacity) {
        this.store = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!store.containsKey(key)){ 
            return -1;
        }
        onKeyAccesed(key);
        return store.get(key);
    }
    
    public void put(int key, int value) {
        store.put(key, value); 
        onKeyAccesed(key);
        if(store.size() > capacity){ 
            evict();
        }
    }
    public void onKeyAccesed(int key){ 
        int value = store.get(key); 
        store.remove(key); 
        store.put(key, value);
    }
    public void evict(){ 
       int vicitim = store.firstEntry().getKey();
       store.remove(vicitim);
    } 
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */