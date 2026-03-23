class Solution {
    public boolean isIsomorphic(String firstWord, String secondWord) {
        if (firstWord == null && secondWord == null)
            return false;
        if (firstWord.length() != secondWord.length())
            return false;
        if (firstWord.length() < 2)
            return true; // single character are isomorpphic
        int[] charMap1 = new int[256];
        int[] charMap2 = new int[256];
        // do not fill -1 512 waste 
        // use i + 1
        for (int i = 0; i < firstWord.length(); i++) {
            if (charMap1[firstWord.charAt(i)] != charMap2[secondWord.charAt(i)])
                return false;
            if (charMap1[firstWord.charAt(i)] == 0)
                charMap1[firstWord.charAt(i)] = i + 1;
            if (charMap2[secondWord.charAt(i)] == 0)
                charMap2[secondWord.charAt(i)] = i + 1;
        }
        return true;
    }
}