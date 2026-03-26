class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.addLast(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        // get replace the element with lastindex in list
        if (map.containsKey(val)) {
            int index = map.get(val);
            int endValue = list.get(list.size() - 1);
            list.set(index, endValue);
            map.put(endValue, index);
            map.remove(val);
            list.removeLast();
            return true;

        }
        return false;
    }

    public int getRandom() {
        if(list.isEmpty() || map.isEmpty()) throw new IllegalAccessError("Empty data"); 
        int index = ThreadLocalRandom.current().nextInt(0, list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */