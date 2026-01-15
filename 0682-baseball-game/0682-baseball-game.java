import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack <Integer> stack = new Stack<>();
        int sum = 0 ; 
        for(String s : operations){
            if(s.equals("C")  ){
                int val = stack.pop();
                sum -= val;
            }
            else if(s.equals("D")){
                 int val = stack.peek();
                 sum += 2*val;
                 stack.add(2*val);
            }
            else if(s.equals("+")){
            int b = stack.pop();
            int a = stack.peek();
            sum += (a + b);
            stack.push(b);
            stack.push(a+b);
            }
            else{
                int num = Integer.parseInt(s);
                stack.add(num);
                sum += num;
            }




        }
   return sum; }
}