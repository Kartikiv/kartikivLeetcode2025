class Solution {
    public boolean wordPattern(String pattern, String s) {
        String [] words = s.split("\\s+");
        char [] patternArr = pattern.toCharArray();
        if(words.length != patternArr.length) return false;

        Map<Character, String> charToWord = new HashMap<>(); 
        Map <String, Character> wordToChar = new HashMap<>();
        for(int i = 0 ; i < words.length; i++){
            wordToChar.putIfAbsent(words[i], patternArr[i]);
            charToWord.putIfAbsent(patternArr[i], words[i]);
             if (wordToChar.get(words[i]) != patternArr[i] ||
                !charToWord.get(patternArr[i]).equals(words[i])) {
                return false;
            }
        }

    return true; 
    }
}