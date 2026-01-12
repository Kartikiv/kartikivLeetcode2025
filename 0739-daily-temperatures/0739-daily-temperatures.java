// We can Use a stack and append from the front and then we we append
// We can do this by add and poping when we see a larger number 
class Node {
    int val; 
    int index;

    public Node(int val, int index){
        this.val = val;
        this.index = index; 
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack <Node> stack = new Stack<>();
        int [] ans = new int[temperatures.length];
        for (int i  = 0; i < temperatures.length; i++){
            int num = temperatures[i];
            while(!stack.isEmpty() && stack.peek().val < num){
                Node node = stack.pop();
                ans[node.index] = i - node.index;
            }
            stack.add(new Node(num, i));
        }

        while(!stack.isEmpty() ){
                Node node = stack.pop();
                ans[node.index] = 0;
            }
    return ans; }
}