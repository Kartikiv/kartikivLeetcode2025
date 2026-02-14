class Solution {
    public int maxVowels(String s, int k) {
        int maxVowel = 0;
        int i = 0;
        int j = 0;
        int vowel = 0;
        while (j < k) {
            if (isVowel(s.charAt(j))) {
                vowel++;
            }
            j++;
        }
        maxVowel = vowel;

        while (j < s.length()) {
            if (isVowel(s.charAt(i)))
                vowel--;
            i++;
            if(isVowel(s.charAt(j))){
                vowel++;
            }
            j++;
            maxVowel = Math.max(vowel, maxVowel);

        }
    return  maxVowel; }

    boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}