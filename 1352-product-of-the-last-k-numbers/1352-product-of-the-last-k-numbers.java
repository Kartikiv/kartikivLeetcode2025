class ProductOfNumbers {
    List<Integer> stream;
    int size;
    public ProductOfNumbers() {
        this.stream = new ArrayList<>();
        this.stream.add(1);
        this.size = 0;
    }
    
    public void add(int num) {
        if(num == 0){
            stream = new ArrayList<>();
            stream.add(1); 
            size =0;
        }else{ 
            stream.add(stream.get(size) * num); 
            size++;
        }
    }
    
    public int getProduct(int k) {
        if(k > size) return 0;
        return stream.get(size) / stream.get(size - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */