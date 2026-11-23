class ProductOfNumbers {
    List<Integer> stream;
    public ProductOfNumbers() {
        this.stream = new ArrayList<>();
    }
    
    public void add(int num) {
        stream.add(num);
    }
    
    public int getProduct(int k) {
        int size = stream.size(); 
        int product = 1;
        for(int i = size - 1; i >= size - k; i--){
            product *= stream.get(i);
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */