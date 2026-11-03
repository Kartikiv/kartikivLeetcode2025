/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
     boolean flag = false;
     int count =0;
     int nval = n;
     
    char [] temp = new char[4];
     while(!flag && n>0 ){
        int val = read4(temp);
        if(val == 0) flag = true;
        
        for(int i = 0 ; i < val; i++){
            char c = temp[i];
            if(c != '\u0000' && n>0){
            buf[count++] = c;
            n--;
            }
        }

     }
   //  System.out.print(count);
  return count;  }
}