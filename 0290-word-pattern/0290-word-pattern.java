class Solution {
    public boolean wordPattern(String pattern, String s) {
        //encode the two string and compare 

        return encodePattern(pattern).equals(encodeString(s));
    }

    public String encodePattern(String pattern) {
        int[] charMap = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            if (charMap[pattern.charAt(i) - 'a'] == 0)
                charMap[pattern.charAt(i) - 'a'] = i + 1;
            sb.append(charMap[pattern.charAt(i) - 'a']).append(":");
        }
        return sb.toString();
    }

    public String encodeString(String s) {
        String[] divideStrings = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> sMap = new HashMap<>();
        for (int i = 0; i < divideStrings.length; i++) {
            sMap.putIfAbsent(divideStrings[i], i + 1);
            sb.append(sMap.get(divideStrings[i])).append(":"); // adding a delimeter 
        }
        return sb.toString();
    }
}