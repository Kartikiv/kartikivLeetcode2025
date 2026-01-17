class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTen = 0 ; 
        int countTwenty = 0;

        for(int bill : bills){
            switch (bill) {
                case 5 -> countFive++;
                case 10 -> {
                    if(countFive < 1){
                        return false;
                    }   countTen++;
                    countFive--;
                }
                default -> {
                    countTwenty++;
                    if(countTen >= 1 && countFive >= 1){
                        countTwenty++;
                        countFive--;
                        countTen--;
                    }else if(countFive >= 3){
                        countFive = countFive - 3;
                        countTwenty++;
                    }else{
                        return false;
                    }
                }
            }
        
            }
        
        return  true;}

       
}