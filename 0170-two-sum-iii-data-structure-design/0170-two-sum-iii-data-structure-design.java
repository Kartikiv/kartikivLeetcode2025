class TwoSum {
    HashMap<Integer, Integer> numMap;

    public TwoSum() {
        this.numMap = new HashMap<>();
    }

    public void add(int number) {
        numMap.put(number, numMap.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {

        for (int val : numMap.keySet()) {
            if (numMap.containsKey(value - val)) {
                if (! (val == value - val && numMap.get(val) <= 1) ) {
                    return true;
                } 
            }
        }

        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */