
class Solution{ 
public int minimumLength(String s){ 
    int remainingStringLength = 0;
    int i = 0; 
    int j = s.length() - 1;
        /*
        States im traking:
        1. if i and j equal:
            we move i till we till we find the new not equal character 
            the same with j 
            
        2. if they are not equal then we add 2 to the remainingStringLength
        */
        while(i < j && s.charAt(i) == s.charAt(j)){
            char c = s.charAt(i);
            while(i <= j && s.charAt(i) == c){
                i++;
            }
            while(j >= i && s.charAt(j) == c){
                j--;
            }     
        }
    
return j != i ? j - i + 1 : 1; 
}
}










































