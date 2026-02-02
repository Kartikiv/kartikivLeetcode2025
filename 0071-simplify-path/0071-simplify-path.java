import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        path = path + "/";
       for (char c : path.toCharArray()) {
           if(c == '/'){
            if(!sb.isEmpty()){
                String s = sb.toString();
                if(s.equals(".")){
                    
                }
                else if(s.equals("..")){
                   if(!stack.isEmpty()) stack.pop();
                }
                else{
                    stack.add("/" + s);
                }
                
                
            } 
            sb = new StringBuilder();
           }else{
            sb.append(c);
           }


       }

       sb = new StringBuilder();
       while(!stack.isEmpty()){
        StringBuilder build = new StringBuilder(stack.pop());
        sb.append(build.reverse());
       }
       String ans = sb.reverse().toString();
   return ans.equals("") ? "/" : ans; }
}