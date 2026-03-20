class Solution {
    int index;
    public int calculate(String s) {
        // do dfs 
        return dfs(s.toCharArray());
    }
    int dfs (char [] arr){
        long sum = 0 , operator = 1;
        while(index < arr.length){
            if(arr[index] == ')'){
                break;
            }
            if(arr[index] == '('){
                index++;
                sum += operator * dfs(arr);
            }else if(arr[index] == '-'){
                operator = - 1;
            }else if(arr[index] == '+'){
                operator = 1;
            }
            else if(Character.isDigit(arr[index])){
                long num  = 0 ;
                long base = 1 ;
                while(index < arr.length && Character.isDigit(arr[index])){
                    num = num * 10 + (arr[index] - '0');
                    index ++; 
                }
                index--;
                sum += num * operator;
            }
            index++;
        }
    return (int) sum ;}
}