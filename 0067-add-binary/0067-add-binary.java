class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int len = a.length() > b.length() ? a.length() : b.length();
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        char carry = '0';
        for(int i = len ; i > 0; i-- ){
            char charA = indexA >= 0 ? a.charAt(indexA) : '0';
            char charB = indexB >= 0 ? b.charAt(indexB) : '0'; 
            if(charA == '1' && charB == '1' ){
                if(carry == '0'){
                    ans.insert(0, '0');
                    carry = '1';
                }else{
                    ans.insert(0, '1');
                     carry = '1';
                }
            }
            if( (charA == '1' && charB == '0' ) || (charA == '0' && charB == '1') ){
                if(carry == '0'){
                    ans.insert(0, '1');
                    
                }else{
                    ans.insert(0, '0');
                    carry = '1';
                }
            }
            if( charA == '0' && charB == '0') {
                if(carry == '1'){
                ans.insert(0, '1');
                carry = '0';
                }else{
                     ans.insert(0, '0');
                }

            }
            indexA--;
            indexB--;

        }
        if(carry == '1') ans.insert(0, '1');

    return ans.toString();}
}