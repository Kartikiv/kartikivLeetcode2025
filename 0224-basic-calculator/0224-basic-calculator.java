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
                StringBuilder sb = new StringBuilder();
                while(index < arr.length && Character.isDigit(arr[index])){
                    sb.append(arr[index]);
                    index ++; 
                }
                index--;
                sum += Long.parseLong(sb.toString())  * operator;
            }
            index++;
        }
    return (int) sum ;}
}